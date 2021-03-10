package rechard.learn.eshop.common.json;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Rechard
 **/
public class LeafStringExpression extends AbstractCompositeJsonExpression{
    public LeafStringExpression(String expression) {
        super(expression);
    }

    /**
     *
     *
     * @param context json表达式上下文
     * @return 返回结果
     */
    @Override
    public Object interprect(JsonExpresionContext context) throws Exception{
        Object current=context.getCurrent();
        if(current instanceof String){
            return ((String)context.getCurrent());
        }else{
            throw new Exception("node key="+expression+" is not String");
        }
    }
}
