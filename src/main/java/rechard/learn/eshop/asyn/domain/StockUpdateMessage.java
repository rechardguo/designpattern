package rechard.learn.asyn.domain;

/**
 * 通知WMS的库存更新消息
 */
public class StockUpdateMessage {

    public static final int ACTION_SUBMITORDER=1;

    private int Id;
    //消息的操作类型
    private int action;
    private Object param;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "StockUpdateMessage{" +
                "Id=" + Id +
                ", action=" + action +
                ", param=" + param +
                '}';
    }
}
