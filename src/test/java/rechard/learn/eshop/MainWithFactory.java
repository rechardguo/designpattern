package rechard.learn.eshop;

import rechard.learn.eshop.asyn.OfflineMessageStorageMananger;
import rechard.learn.eshop.asyn.StockUpdateQueue;
import rechard.learn.eshop.domain.Account;
import rechard.learn.eshop.domain.CommodityDo;
import rechard.learn.eshop.domain.CustomerDo;
import rechard.learn.eshop.domain.OrderDto;
import rechard.learn.eshop.mock.*;
import rechard.learn.eshop.inventory.service.InventoryService;
import rechard.learn.eshop.inventory.service.PurchaseInputStockUpdaterFactory;
import rechard.learn.eshop.inventory.service.StockUpdater;
import rechard.learn.eshop.inventory.service.SubmitOrderStockUpdaterFactory;
import rechard.learn.eshop.domain.PurchaseDto;
import rechard.learn.eshop.schedule.StockUpdateQueueConsumer;

import java.util.ArrayList;
import java.util.List;

import static rechard.learn.eshop.mock.MockAuthDB.mockPurchaserLucy;
import static rechard.learn.eshop.mock.MockCommodityDB.mockIphone6;
import static rechard.learn.eshop.mock.MockCommodityDB.mockIphone7;
import static rechard.learn.eshop.mock.MockData.mockDataFromCustomer;
import static rechard.learn.eshop.mock.MockData.mockDataFromPurchaseCenter;


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

        new StockUpdateQueueConsumer().start();

        OrderDto order = mockDataFromCustomer();
        InventoryService service=new InventoryService();
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
