package rechard.learn.degsinpattern;


import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestJsonPlaceHolder {

    @Test
    public void testReplace(){
        String jsonStr="{ref:'abc',list:[{name:'1'},{name:'2'},{name:'3'}]}";
        JSONObject json=JSONObject.parseObject(jsonStr);

        Map m=new HashMap();
        new JsonObjectElement(json).replaceHolder(new PlaceHolderVisitor(m));
    }
}
