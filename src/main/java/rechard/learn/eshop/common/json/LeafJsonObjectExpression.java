package rechard.learn.eshop.common.json;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Rechard
 **/
public class LeafJsonObjectExpression extends AbstractCompositeJsonExpression{
    public LeafJsonObjectExpression(String expression) {
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
        //说明是root结点
        //{‘amount’:300.0}
        /*if(context.getParent()==null){

        }else{
            //{ threadhold:{‘amount’:300.0,'currency':'CNY'}}
            //parent 就是 { threadhold:{‘amount’:300.0,'currency':'CNY'}}
            //curent 就是 {‘amount’:300.0,'currency':'CNY'}
            return context.getParent().get(this.jsonExpressionName);
        }*/
        Object current=context.getCurrent();
        if(current instanceof JSONObject){
            return ((JSONObject)context.getCurrent()).get(expression);
        }else{
            throw new Exception("node key="+expression+" is not jsonobject");
        }
    }
}
