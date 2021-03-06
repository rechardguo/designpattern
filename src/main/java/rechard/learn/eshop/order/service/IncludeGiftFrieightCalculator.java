package rechard.learn.eshop.order.service;

import rechard.learn.eshop.mock.MyRandom;
import rechard.learn.eshop.order.service.domain.OrderItemInfoDTO;

/**
 * 默认的订单运费计算器
 */
public class IncludeGiftFrieightCalculator implements OrderFreightCalculator {
    public double calculate(OrderItemInfoDTO orderItem,PromotionActivityResult promotionActivityResult)
            throws Exception {
        System.out.println("调用运费中心的接口,传入skuid,计算出一个运费");
        //这里就使用随机数据来做
        double feight= MyRandom.random();
        // 由于礼品可能需要运费，所以这里也加入了礼物的运费计算
        for(OrderItemInfoDTO item:promotionActivityResult.getGifts()){
            feight+=MyRandom.random();
        }
        return feight;
    }
}
