package rechard.learn.eshop.common.json;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Rechard
 **/
public class JsonExpresionContext {
    //父类结点
   // private JSONObject parent=null;
    //当前结点
    private Object current=null;

    /*public JSONObject getParent() {
        return parent;
    }

    public void setParent(JSONObject parent) {
        this.parent = parent;
    }*/

    public Object getCurrent() {
        return current;
    }

    public void setCurrent(Object current) {
        this.current = current;
    }
}
