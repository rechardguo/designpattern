package rechard.learn.asyn;

import java.util.Observable;
import java.util.Observer;

/**
 * 消息更新的可供观察类
 */
public class StockUpdateObservable extends Observable {

    private int msgId;

    public StockUpdateObservable(int msgId) {
        this.msgId = msgId;
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    public void complete(){
        this.setChanged();
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }
}
