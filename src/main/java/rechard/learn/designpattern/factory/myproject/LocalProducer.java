package rechard.learn.designpattern.factory.myproject;

import java.util.HashMap;

/**
 * @author Rechard
 **/
public class LocalProducer implements Producer{
    @Override
    public Object produce(HashMap params) throws Exception{
        String beanName=(String)params.get("beanName");
        if(beanName!=null){
            return Class.forName(beanName).newInstance();
        }
        return null;
    }
}
