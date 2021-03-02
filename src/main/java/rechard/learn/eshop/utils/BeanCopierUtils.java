package rechard.learn.eshop.utils;

import net.sf.cglib.beans.BeanCopier;
import rechard.learn.eshop.domain.OrderDto;
import rechard.learn.eshop.domain.OrderVo;

import java.util.HashMap;
import java.util.Map;

public class BeanCopierUtils {

    private Map beanCopierCache=new HashMap<>();

    public void copy(Object source ,Object target){



    }

    public static void main(String[] args) {
        OrderVo orderVo=new OrderVo();
        orderVo.setCustomerId(123);
        orderVo.setCustomerName("rechard");
        OrderDto orderDto=new OrderDto();
        BeanCopier copier=BeanCopier.create(orderVo.getClass(),orderDto.getClass(),false);
        copier.copy(orderVo,orderDto,null);
        System.out.println(orderDto);
    }

}
