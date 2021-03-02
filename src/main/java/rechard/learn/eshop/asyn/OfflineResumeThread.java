package rechard.learn.asyn;

import rechard.learn.asyn.domain.StockUpdateMessage;
import rechard.learn.data.mock.MockSpringContext;
import rechard.learn.data.mock.MockoffilineStockUpdateMsgStorageDB;

import java.util.Iterator;
import java.util.List;

/**
 * 离线消息恢复线程
 */
public class OfflineResumeThread extends Thread{
    OfflineMessageStorageMananger offlineMessageStorageMananger
            = MockSpringContext.offlineMessageStorageMananger;
    StockMessageManager stockMessageManager=MockSpringContext.stockMessageManager;
    StockUpdateQueue stockUpdateQueue=MockSpringContext.stockUpdateQueue;
    public void run() {
        Iterator<List<StockUpdateMessage>> it=offlineMessageStorageMananger.iterator();
        while (it.hasNext()){
            List<StockUpdateMessage> list=it.next();
            for (StockUpdateMessage msg:list) {
                stockUpdateQueue.add(msg);
            }
        }
        //处理完所有的离线消息后，flag标成false
        offlineMessageStorageMananger.setOffline(false);
    }
}
