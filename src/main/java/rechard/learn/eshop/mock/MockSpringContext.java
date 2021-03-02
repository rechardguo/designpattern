package rechard.learn.eshop.mock;

import rechard.learn.eshop.asyn.OfflineMessageStorageMananger;
import rechard.learn.eshop.asyn.StockMessageManager;
import rechard.learn.eshop.asyn.StockUpdateObserver;
import rechard.learn.eshop.asyn.StockUpdateQueue;
import rechard.learn.eshop.inventory.service.SubmitOrderStockUpdaterFactory;

public class MockSpringContext {
    //注意这里的顺序问题，StockUpdateQueue里有引用了offlineMessageStorageMananger
    //所以offlineMessageStorageMananger需要先初始化
    //暂时只能这样解决

    //这里也引出了一个问题，如果spring遇到这样的时候是如何解决的？
    //写了个rechard.learn.eshop.mock.spring里面的Context留待后面解决

    public static OfflineMessageStorageMananger offlineMessageStorageMananger=new OfflineMessageStorageMananger();
    public static StockUpdateQueue stockUpdateQueue=new StockUpdateQueue();
    public static StockMessageManager stockMessageManager=new StockMessageManager();
    public static StockUpdateObserver stockUpdateObserver=new StockUpdateObserver();
    public static SubmitOrderStockUpdaterFactory submitOrderStockUpdaterFactory=new SubmitOrderStockUpdaterFactory();

}
