package rechard.learn.eshop.utils;

import net.sf.cglib.beans.BeanCopier;
import rechard.learn.eshop.domain.OrderDto;
import rechard.learn.eshop.domain.OrderVo;

import java.util.HashMap;
import java.util.Map;

public class BeanCopierUtils {

    private static Map<String,BeanCopier> beanCopierCache=new HashMap<>();

    public static void  copy(Object source ,Object target){
        Class sourceClass=source.getClass();
        Class targetClass=target.getClass();

        String key=sourceClass.getName()+"-"+targetClass.getName();
        BeanCopier copier=null;

        //解决并发时候2个线程同时进来,请求的同样的source和target
        //此时beanCopierCache里是没有缓存的
        if((copier=beanCopierCache.get(key))==null) {
            //只会有1个进来
            synchronized (BeanCopierUtils.class) {
                //另外那个进来的时候再判断下时候已经好了
                if ((copier=beanCopierCache.get(key))==null) {
                    copier=BeanCopier.create(sourceClass,targetClass,false);
                    beanCopierCache.put(key,copier);
                }
            }
        }
        copier.copy(source,target,null);
    }

  /*  public static void main(String[] args) {
        OrderVo orderVo=new OrderVo();
        orderVo.setCustomerId(123);
        orderVo.setCustomerName("rechard");
        OrderDto orderDto=new OrderDto();
        BeanCopierUtils.copy(orderVo,orderDto);
        System.out.println(orderDto);
    }*/

}
