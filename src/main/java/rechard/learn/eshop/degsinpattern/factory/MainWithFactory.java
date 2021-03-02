package rechard.learn.degsinpattern.factory;

import rechard.learn.auth.domain.Account;
import rechard.learn.commodity.domain.CommodityDo;
import rechard.learn.customer.domain.CustomerDo;
import rechard.learn.customer.domain.OrderDto;
import rechard.learn.data.mock.*;
import rechard.learn.inventory.service.InventoryService;
import rechard.learn.inventory.service.PurchaseInputStockUpdaterFactory;
import rechard.learn.inventory.service.StockUpdater;
import rechard.learn.inventory.service.SubmitOrderStockUpdaterFactory;
import rechard.learn.purchase.domain.PurchaseDto;
import rechard.learn.schedule.StockUpdateQueueConsumer;

import java.util.ArrayList;
import java.util.List;

import static rechard.learn.data.mock.MockAuthDB.mockPurchaserLucy;
import static rechard.learn.data.mock.MockCommodityDB.mockIphone6;
import static rechard.learn.data.mock.MockCommodityDB.mockIphone7;
import static rechard.learn.data.mock.MockData.mockDataFromCustomer;
import static rechard.learn.data.mock.MockData.mockDataFromPurchaseCenter;


/**
 * 对比MainWithOutFactory,就可以看出工厂方法的好处了
 */

public class MainWithFactory {

    public static void main(String[] args) {
        /**
         * 模拟客户rechard下了个iphone6的订单
         */
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
