package rechard.learn.eshop.mock;

import rechard.learn.eshop.asyn.OfflineMessageStorageMananger;
import rechard.learn.eshop.asyn.StockMessageManager;
import rechard.learn.eshop.asyn.StockUpdateObserver;
import rechard.learn.eshop.asyn.StockUpdateQueue;
import rechard.learn.eshop.inventory.service.SubmitOrderStockUpdaterFactory;

public class MockSpringContext {
    public static StockUpdateQueue stockUpdateQueue=new StockUpdateQueue();
    public static StockMessageManager stockMessageManager=new StockMessageManager();
    public static StockUpdateObserver stockUpdateObserver=new StockUpdateObserver();
    public static SubmitOrderStockUpdaterFactory submitOrderStockUpdaterFactory=new SubmitOrderStockUpdaterFactory();

    public static OfflineMessageStorageMananger offlineMessageStorageMananger=new OfflineMessageStorageMananger();
}
