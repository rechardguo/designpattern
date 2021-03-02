package rechard.learn.designpattern.visitor.myproject;

import com.alibaba.fastjson.JSONArray;

public class JsonArrayElement extends Element<JSONArray> {
    public JsonArrayElement(JSONArray json) {
        super(json);
    }
}