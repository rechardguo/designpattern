package rechard.learn.inventory.service;

/**
 * 取得Command的工厂类
 */
public interface StockUpdaterFactory {
    //创建具体的command方法
    StockUpdater create();
}
