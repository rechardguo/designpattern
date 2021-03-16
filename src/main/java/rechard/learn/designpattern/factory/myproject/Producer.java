package rechard.learn.designpattern.factory.myproject;

import java.util.HashMap;

/**
 * @author Rechard
 **/
public interface Producer {
    public Object produce(HashMap params) throws Exception;
}
