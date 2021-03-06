package rechard.learn.eshop.order.service;

import rechard.learn.eshop.order.service.domain.OrderItemInfoDTO;
import rechard.learn.eshop.promotion.domain.PromotionDTO;

/**
 * 默认的商品折扣计算器
 */
public class DefaultOrderDiscountCalculator implements PromotionActivityCalculator {

    public PromotionActivityResult calculate(OrderItemInfoDTO orderItem, PromotionDTO promotion) {
        PromotionActivityResult result=new PromotionActivityResult();
        return result;
    }
}
