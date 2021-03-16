package rechard.learn.designpattern.factory.myproject;

import java.io.IOException;

/**
 * @author Rechard
 **/
public interface ObjectFactory {

    /**
     * 根据beanName来找到一个Object
     * @param beanName
     * @return
     */
    public Object cretate(String beanName) throws Exception;
}
