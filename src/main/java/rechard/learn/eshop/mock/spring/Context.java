package rechard.learn.eshop.mock.spring;


import java.util.HashMap;
import java.util.Map;

/**
 * 这里其实引出了spring的一个问题
 */
public class Context{
    static Map<String,Object> nameBeanMap=new HashMap<>();

    public static Object get(Class beanClass)  {
        Object bean=null;
        if((bean=nameBeanMap.get(beanClass.getName()))!=null){
            return bean;
        }
        try {
            bean=beanClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        nameBeanMap.put(beanClass.getName(),bean);
        return bean;
    }
}
