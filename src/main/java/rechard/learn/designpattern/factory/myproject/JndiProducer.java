package rechard.learn.designpattern.factory.myproject;

import java.util.HashMap;

/**
 * @author Rechard
 **/
public class JndiProducer implements Producer{
    @Override
    public Object produce(HashMap params) {
        return JndiContainer.get();
    }
}
