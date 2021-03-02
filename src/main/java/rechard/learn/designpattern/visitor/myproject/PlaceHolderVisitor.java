package rechard.learn.designpattern.visitor.myproject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaceHolderVisitor implements Visitor {

    //replace holder的值的替换来源
    private Map context;

    public PlaceHolderVisitor(Map context) {
        this.context = context;
    }

    static Pattern JsonPlaceHolderPattern=Pattern.compile("(\\$\\(.*?\\))");
    @Override
    public void accept(Element el) {
        JSON json=el.getElement();
        if(json instanceof JSONObject){
            JSONObject jsonObj=(JSONObject)json;
            Set<String> keys=jsonObj.keySet();
            Iterator<String> it= keys.iterator();
            while (it.hasNext()){
                String key=it.next();
                Object value=jsonObj.get(key);
                parse(value);
            }
        }else if(json instanceof JSONArray){
            JSONArray jsonArr=(JSONArray)json;
            for(int i=0;i<jsonArr.size();i++){
                Object value=jsonArr.get(i);
                parse(value);
            }
        }
    }

    private void parse(Object value) {
        if (value instanceof String) {
            System.out.println("parse:"+value);
        }else if(value instanceof JSONObject){
            new JsonObjectElement((JSONObject)value).replaceHolder(this);
        }else if(value instanceof JSONArray){
            new JsonArrayElement((JSONArray)value).replaceHolder(this);
        }
    }

    private String parsePlaceHolder(String json) {
        Matcher matcher = JsonPlaceHolderPattern.matcher(json);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            //expGrp naming rule as:  <api>.<req|resp>.<field>
            String expGrp = matcher.group();
            expGrp = expGrp.substring(expGrp.indexOf('(') + 1, expGrp.indexOf(')'));
            String api = expGrp.substring(0, expGrp.indexOf('.'));
            expGrp = expGrp.substring(expGrp.indexOf('.') + 1);
            String type = expGrp.substring(0, expGrp.indexOf('.'));
            expGrp = expGrp.substring(expGrp.indexOf('.') + 1);
            String field = expGrp;
            matcher.appendReplacement(result, "abc");
        }
        matcher.appendTail(result);
        return result.toString();

    }

}
