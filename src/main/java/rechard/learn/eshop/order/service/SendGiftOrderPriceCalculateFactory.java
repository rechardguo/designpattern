package rechard.learn.eshop.order.service;


/**
 * 送礼品的订单价格计算工厂
 */
public class SendGiftOrderPriceCalculateFactory implements OrderPriceCalculateFactory{
    @Override
    public OrderPriceCalculator createOrderPriceCalculator() {
        return new DefaultOrderPriceCalculator();
    }

    @Override
    public OrderFreightCalculator createOrderFreightCalculator() {
        return new IncludeGiftFrieightCalculator();
    }

    @Override
    public PromotionActivityCalculator createOrderPromotionCalculator() {
        return new SendGiftPromotionCalculator();
    }
}
