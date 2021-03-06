package rechard.learn.eshop.order.service;

import rechard.learn.eshop.order.service.domain.OrderItemInfoDTO;
import rechard.learn.eshop.promotion.domain.PromotionDTO;

/**
 * 没有任何的促销
 * 则促销价格为0
 */
public class NoneDiscountOrderPriceCalculator implements PromotionActivityCalculator {

    public PromotionActivityResult calculate(OrderItemInfoDTO orderItem, PromotionDTO promotion) {
        PromotionActivityResult result=new PromotionActivityResult();
        result.setDiscountAmount(0.0);
        return result;
    }
}
