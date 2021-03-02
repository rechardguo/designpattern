package rechard.learn.eshop.asyn;

import rechard.learn.eshop.asyn.domain.StockUpdateMessage;
import rechard.learn.eshop.mock.MockSpringContext;
import rechard.learn.eshop.mock.MockoffilineStockUpdateMsgStorageDB;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class StockUpdateQueue {
    private int maxLen=10; //最大深度默认是10

    private ArrayBlockingQueue<StockUpdateMessage> queue=new ArrayBlockingQueue(maxLen);
    private OfflineMessageStorageMananger offlineMessageStorageMananger=MockSpringContext.offlineMessageStorageMananger;
    public StockUpdateQueue(){
    }
    public void putDirect(StockUpdateMessage stockUpdateMessage){
        queue.add(stockUpdateMessage);
    }

    public void add(StockUpdateMessage stockUpdateMessage){
        if(offlineMessageStorageMananger.isOffline()){
            MockoffilineStockUpdateMsgStorageDB.save(stockUpdateMessage);
        }
        //加入队列满了后就离线存储的处理逻辑
        if(queue.size()>=maxLen){
            //开启离线机制
            offlineMessageStorageMananger.setOffline(true);
            MockoffilineStockUpdateMsgStorageDB.save(stockUpdateMessage);
        }
        if(queue.size()==0){
            //队列里的消息为0后，就开启离线线程来启动处理消息
            new OfflineResumeThread().start();
        }
        queue.add(stockUpdateMessage);
    }
    public boolean remove(StockUpdateMessage stockUpdateMessage){
        return queue.remove(stockUpdateMessage);
    }
    public StockUpdateMessage take() throws InterruptedException {
        return this.queue.take();
    }
}
