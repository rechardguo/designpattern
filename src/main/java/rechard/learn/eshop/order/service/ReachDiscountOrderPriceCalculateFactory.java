package rechard.learn.eshop.order.service;


/**
 * 直接则扣的订单计算器
 */
public class ReachDiscountOrderPriceCalculateFactory implements OrderPriceCalculateFactory{
    @Override
    public OrderPriceCalculator createOrderPriceCalculator() {
        return new DefaultOrderPriceCalculator();
    }

    @Override
    public OrderFreightCalculator createOrderFreightCalculator() {
        return new DefaultOrderFrieightCalculator();
    }

    @Override
    public PromotionActivityCalculator createOrderPromotionCalculator() {
        return new ReachOrderDiscountCalculator();
    }
}
