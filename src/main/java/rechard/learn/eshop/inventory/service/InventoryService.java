package rechard.learn.eshop.inventory.service;

import rechard.learn.asyn.StockMessageManager;
import rechard.learn.asyn.StockUpdateObservable;
import rechard.learn.asyn.StockUpdateObserver;
import rechard.learn.asyn.domain.StockUpdateMessage;
import rechard.learn.asyn.StockUpdateQueue;
import rechard.learn.customer.domain.OrderDto;
import rechard.learn.data.mock.MockSpringContext;
import rechard.learn.data.mock.MyRandom;

import java.util.Observable;

public class InventoryService {

    SubmitOrderStockUpdaterFactory submitOrderStockUpdaterFactory=
            MockSpringContext.submitOrderStockUpdaterFactory;

    StockMessageManager messageManager=MockSpringContext.stockMessageManager;
    StockUpdateObserver stockUpdateObserver=MockSpringContext.stockUpdateObserver;
    /**
     * 通知 库存中心 “客户下订单” 事件
     */
    public void informCustomerSubmitOrder(OrderDto order){
        //更新本地库存
        submitOrderStockUpdaterFactory.setParams(order);
        StockUpdater stockUpdater=submitOrderStockUpdaterFactory.create();
        stockUpdater.update();

        //发送异步消息到queue里通知WMS
        StockUpdateQueue queue=MockSpringContext.stockUpdateQueue;
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
