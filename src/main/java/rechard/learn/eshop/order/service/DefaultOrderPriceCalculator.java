package rechard.learn.eshop.order.service;

import rechard.learn.eshop.order.service.domain.OrderItemInfoDTO;

/**
 * 默认的订单价格计算器
 */
public class DefaultOrderPriceCalculator implements OrderPriceCalculator {
    /**
     * 计算正常的订单价格
     * @param orderItem
     * @return
     */
    public double calculate(OrderItemInfoDTO orderItem) {
        return orderItem.getPrice()*orderItem.getQuantity();
    }
}
