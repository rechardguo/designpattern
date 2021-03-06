package rechard.learn.eshop.order.service;

import rechard.learn.eshop.order.service.domain.OrderItemInfoDTO;

/**
 * 商品运费计算器
 */
public interface OrderFreightCalculator {
    /**
     * 根据商品计算出订单的运费
     * @param orderItem 订单项
     * @parm PromotionActivityResult 促销项
     * @return 订单运费
     * @throws Exception
     */
    public double calculate(OrderItemInfoDTO orderItem,PromotionActivityResult result)
            throws Exception;
}
