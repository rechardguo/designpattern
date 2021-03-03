package rechard.learn.eshop.mock.spring;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Context{
    private Map<String,Object> nameBeanMap=new HashMap<>();

    public <T> T get(Class<T> beanClass) {
        T bean=null;
        if((bean=(T)nameBeanMap.get(beanClass.getName()))!=null){
            return bean;
        }
        try {
            bean=beanClass.newInstance();
            nameBeanMap.put(beanClass.getName(),bean);

            Field[]  fields=beanClass.getDeclaredFields();
            for(Field field:fields){
                Autowired autowired=null;
                //扫描class 所有的fields，发现有 @Autowired的field
                if((autowired=field.getAnnotation(Autowired.class))!=null){
                    Class<?> cl=field.getType();
                    Object injectBean=this.get(cl);
                    field.setAccessible(true);
                    field.set(bean,injectBean);
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return bean;
    }

    public static void main(String[] args) throws Exception {
        Context ctx=new Context();
        Cat cat=ctx.get(Cat.class);
        Mouse mouse=ctx.get(Mouse.class);
        System.out.println(cat.food==mouse);
        System.out.println(cat==mouse.hunter);
    }

}
