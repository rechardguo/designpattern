package rechard.learn.eshop.order.service;

import rechard.learn.eshop.order.service.domain.OrderItemInfoDTO;

public interface OrderPriceCalculator {

    double calculate(OrderItemInfoDTO orderItem) throws Exception;
}
