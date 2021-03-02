package rechard.learn.asyn;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class StockMessageManager {

    private Map<Integer, StockUpdateObservable> map=new HashMap();

    public void subscribe(){
        Observable observable=map.get(123);
    }

    /**
     * 监听消息Id
     * @param msgId
     */
    public void observe(StockUpdateObservable stockUpdateObservable){
        map.put(stockUpdateObservable.getMsgId(),stockUpdateObservable);
    }

    public StockUpdateObservable findObserver(int msgId){
        return map.get(msgId);
    }

}
