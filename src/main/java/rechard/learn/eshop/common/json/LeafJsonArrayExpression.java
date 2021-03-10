package rechard.learn.eshop.common.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Rechard
 **/
public class LeafJsonArrayExpression extends JsonArrayExpression{

    public LeafJsonArrayExpression(String expression) {
        super(expression);
    }

    public Object interprect(JsonExpresionContext context) throws Exception{
        Object current=context.getCurrent();
        if(current instanceof JSONObject){
            JSONArray arrayNode=((JSONObject)current).getJSONArray(getNodeName(expression));
            return arrayNode.get(getIndex(expression));
        }
        throw new Exception(expression+"can not be parse for "+current.toString());
    }
}
