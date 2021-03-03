package rechard.learn.eshop.inventory.service;

import rechard.learn.eshop.asyn.StockMessageManager;
import rechard.learn.eshop.asyn.StockUpdateObservable;
import rechard.learn.eshop.asyn.StockUpdateObserver;
import rechard.learn.eshop.asyn.domain.StockUpdateMessage;
import rechard.learn.eshop.asyn.StockUpdateQueue;
import rechard.learn.eshop.domain.OrderDto;
import rechard.learn.eshop.mock.MockSpringContext;
import rechard.learn.eshop.mock.MyRandom;
import rechard.learn.eshop.mock.spring.Autowired;

import java.util.Observable;

public class InventoryService {
    @Autowired
    SubmitOrderStockUpdaterFactory submitOrderStockUpdaterFactory;
    @Autowired
    StockMessageManager messageManager;
    @Autowired
    StockUpdateObserver stockUpdateObserver;
    @Autowired
    StockUpdateQueue queue;
    /**
     * 通知 库存中心 “客户下订单” 事件
     */
    public void informCustomerSubmitOrder(OrderDto order){
        //更新本地库存
        submitOrderStockUpdaterFactory.setParams(order);
        StockUpdater stockUpdater=submitOrderStockUpdaterFactory.create();
        stockUpdater.update();

        //发送异步消息到queue里通知WMS

        StockUpdateMessage msg=new StockUpdateMessage();
        msg.setAction(StockUpdateMessage.ACTION_SUBMITORDER);
        msg.setId(MyRandom.random());
        msg.setParam(order);

        //调用监听者模式监听
        StockUpdateObservable stockUpdateObservable=new StockUpdateObservable(msg.getId());
        stockUpdateObservable.addObserver(stockUpdateObserver);
        messageManager.observe(stockUpdateObservable);

        //将消息发送到队列里
        queue.add(msg);
    }
}
