package rechard.learn.eshop.order.service;

import rechard.learn.eshop.mock.MyRandom;
import rechard.learn.eshop.order.service.domain.OrderItemInfoDTO;

/**
 * 默认的订单运费计算器
 */
public class DefaultOrderFrieightCalculator implements OrderFreightCalculator {
    @Override
    public double calculate(OrderItemInfoDTO orderItem) throws Exception {
        System.out.println("调用运费中心的接口,传入skuid,计算出一个运费");
        //这里就使用随机数据来做
        double feight= MyRandom.random();
        return feight;
    }
}
