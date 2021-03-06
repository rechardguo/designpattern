package rechard.learn.eshop.order.service;

import rechard.learn.eshop.order.service.domain.OrderItemInfoDTO;
import rechard.learn.eshop.promotion.domain.PromotionDTO;

/**
 * 促销活动处理
 */
public interface PromotionActivityCalculator {
    /**
     * 根据商品计算出促销活动的结果
     * @param orderItem 商品
     * @parme promotion 促销信息
     * @return 折扣
     */
    public PromotionActivityResult calculate(OrderItemInfoDTO orderItem,
                                             PromotionDTO promotion)
                        throws Exception;
}
