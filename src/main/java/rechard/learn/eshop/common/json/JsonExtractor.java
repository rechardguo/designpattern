package rechard.learn.eshop.common.json;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Rechard
 **/
public class JsonExtractor {

    public static Object get(JSONObject jsonObject,String expSyntax) throws Exception {
        JsonExpression expression=JsonExpressionSyntaxParser.parse(expSyntax);
        JsonExpresionContext context=new JsonExpresionContext();
        context.setCurrent(jsonObject);
       // context.setParent(null);
        return expression.interprect(context);
    }

    public static String getString(JSONObject jsonObject,String expSyntax) throws Exception {
        return String.valueOf(get(jsonObject,expSyntax));
    }

    public static Integer getInteger(JSONObject jsonObject,String expSyntax) throws Exception {
        return Integer.valueOf(getString(jsonObject,expSyntax));
    }

    public static Double getDouble(JSONObject jsonObject,String expSyntax) throws Exception {
        return Double.valueOf(getString(jsonObject,expSyntax));
    }

    public static Long getLong(JSONObject jsonObject,String expSyntax) throws Exception {
        return Long.valueOf(getString(jsonObject,expSyntax));
    }

    public static void main(String[] args) throws Exception {
        String json="{'amount':300.0}";
        JSONObject jsonObject=JSONObject.parseObject(json);
        double amount=JsonExtractor.getDouble(jsonObject,"amount");
        System.out.println(amount);

        String json2="{'a':{'amount':300.0,'currency':'rmb','user':{'name':'rechard'}}}";
        JSONObject jsonObject2=JSONObject.parseObject(json2);
        String name=JsonExtractor.getString(jsonObject2,"a.user.name");
        System.out.println(name);

        String json3="{'user':{'hobbies':[{'id':1,'name':'basketball'},{'id':2,'name':'football'}],'name':'rechard'}}";
        JSONObject jsonObject3=JSONObject.parseObject(json3);
        String hobbyName=JsonExtractor.getString(jsonObject3,"user.hobbies[1].name");
        System.out.println(hobbyName);
    }

}
