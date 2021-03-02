package rechard.learn.designpattern.visitor.myproject;

import com.alibaba.fastjson.JSONObject;

public class JsonObjectElement extends Element<JSONObject> {
    public JsonObjectElement(JSONObject json) {
        super(json);
    }
}
