package rechard.learn.data.mock;

import rechard.learn.asyn.OfflineMessageStorageMananger;
import rechard.learn.asyn.StockMessageManager;
import rechard.learn.asyn.StockUpdateObserver;
import rechard.learn.asyn.StockUpdateQueue;
import rechard.learn.inventory.service.SubmitOrderStockUpdaterFactory;

public class MockSpringContext {
    public static StockUpdateQueue stockUpdateQueue=new StockUpdateQueue();
    public static StockMessageManager stockMessageManager=new StockMessageManager();
    public static StockUpdateObserver stockUpdateObserver=new StockUpdateObserver();
    public static SubmitOrderStockUpdaterFactory submitOrderStockUpdaterFactory=new SubmitOrderStockUpdaterFactory();

    public static OfflineMessageStorageMananger offlineMessageStorageMananger=new OfflineMessageStorageMananger();
}
