package rechard.learn.eshop;

import rechard.learn.eshop.asyn.StockMessageManager;
import rechard.learn.eshop.asyn.StockUpdateQueue;
import rechard.learn.eshop.domain.OrderDto;
import rechard.learn.eshop.inventory.service.InventoryService;
import rechard.learn.eshop.mock.MockSpringContext;
import rechard.learn.eshop.mock.spring.Autowired;
import rechard.learn.eshop.schedule.StockUpdateQueueConsumer;

import static rechard.learn.eshop.mock.MockData.mockDataFromCustomer;


/**
 * 对比MainWithOutFactory,就可以看出工厂方法的好处了
 */

public class MainWithFactory {

    public static void main(String[] args) {
        /**
         * 模拟客户rechard下了个iphone6的订单
         */
        //OfflineMessageStorageMananger offlineMessageStorageMananger=MockSpringContext.offlineMessageStorageMananger;
        //StockUpdateQueue queue=MockSpringContext.stockUpdateQueue;

        StockUpdateQueue queue=MockSpringContext.Default.get(StockUpdateQueue.class);
        StockMessageManager stockMessageManager=MockSpringContext.Default.get(StockMessageManager.class);
        new StockUpdateQueueConsumer(queue,stockMessageManager).start();
        OrderDto order = mockDataFromCustomer();
        InventoryService service= MockSpringContext.Default.get(InventoryService.class);
        service.informCustomerSubmitOrder(order);
        //System.out.println("========================================");
        /**
         * 采购采购专员lucy采购
         */
       /* List purchaseList=mockDataFromPurchaseCenter();
        PurchaseInputStockUpdaterFactory purchaseInputStockUpdaterFactory=new PurchaseInputStockUpdaterFactory();
        purchaseInputStockUpdaterFactory.setParams(purchaseList);
        StockUpdater stockUpdater=purchaseInputStockUpdaterFactory.create();
        stockUpdater.update();*/
    }
}
