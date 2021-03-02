package rechard.learn.asyn;

import java.util.Observable;
import java.util.Observer;

/**
 * 消息处理的观察者
 */
public class StockUpdateObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("【库存中心】: 监听到消息处理结果:"+arg);
    }
}
