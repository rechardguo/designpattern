package rechard.learn.eshop.common.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Rechard
 **/
public class JsonArrayExpression extends AbstractCompositeJsonExpression {

    public JsonArrayExpression(String expression) {
        super(expression);
    }

    public Object interprect(JsonExpresionContext context) throws Exception{
        Object current=context.getCurrent();
        if(current instanceof JSONObject){
            JSONArray arrayNode=((JSONObject)current).getJSONArray(getNodeName(expression));
            context.setCurrent(arrayNode.get(getIndex(expression)));
            return this.next.interprect(context);
        }
        throw new Exception(expression+"can not be parse for "+current.toString());
    }
    protected static String getNodeName(String expression){
        String NodeName=expression.substring(0,expression.indexOf("[")).trim();
        return NodeName;
    }

    protected static int getIndex(String expression){
        String index=expression.substring(expression.indexOf("[")+1,expression.indexOf("]")).trim();
        return Integer.parseInt(index);
    }
}
