package rechard.learn.eshop.common.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Rechard
 **/
public class CompositeJsonExpression extends AbstractCompositeJsonExpression {
    public CompositeJsonExpression(String expression) {
        super(expression);
    }

    /**
     * a.b.c
     *
     * {a:{b:{c:300}}}
     * @param context
     * @return
     */
    public Object interprect(JsonExpresionContext context) throws Exception {
        JsonExpresionContext childCtx=new JsonExpresionContext();
        //childCtx.setParent(context.getCurrent());
        Object current=context.getCurrent();
        if(current instanceof JSONObject){
            Object  child=((JSONObject)current).get(this.expression);
            childCtx.setCurrent(child);
            return next.interprect(childCtx);
        }else if(current instanceof JSONArray){
            // 遇到array的话必须要是数字
            Object  child=((JSONArray)current).get(Integer.parseInt(this.expression));
            childCtx.setCurrent(child);
            return next.interprect(childCtx);
        }
        return null;
    }
}
