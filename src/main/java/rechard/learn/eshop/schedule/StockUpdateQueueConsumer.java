package rechard.learn.eshop.schedule;

import rechard.learn.eshop.asyn.StockMessageManager;
import rechard.learn.eshop.asyn.StockUpdateObservable;
import rechard.learn.eshop.asyn.StockUpdateQueue;
import rechard.learn.eshop.asyn.domain.StockUpdateMessage;
import rechard.learn.eshop.inventory.domain.StockDo;
import rechard.learn.eshop.mock.MockSpringContext;

import java.util.Observable;

public class StockUpdateQueueConsumer extends Thread{

    private StockUpdateQueue queue= MockSpringContext.stockUpdateQueue;
    private StockMessageManager stockMessageManager=MockSpringContext.stockMessageManager;
    public void run() {
        while (true){

            StockUpdateObservable observable=null;
            try {

                StockUpdateMessage message=queue.take();
                process(message);
                //通知消息监听者消息消费完成
                observable=stockMessageManager.findObserver(message.getId());
                observable.complete();
                observable.notifyObservers("【调度中心】：处理成功");
            } catch (InterruptedException e) {
                observable.notifyObservers("【调度中心】：处理失败"+e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void process(StockUpdateMessage message) {
        System.out.println("【调度中心】：处理消息"+message.toString());
    }
}
