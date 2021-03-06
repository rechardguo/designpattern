package rechard.learn.eshop.order.service;

/**
 * 没有任何的折扣的价格计算工厂
 * 该工厂的组合是
 * 1. 正常的订单价格计算器
 * 2. 正常的运费计算器
 * 3. 折扣计算器
 */
public class DefaultOrderPriceCalculateFactory implements OrderPriceCalculateFactory {

    public OrderPriceCalculator createOrderPriceCalculator() {
        return new DefaultOrderPriceCalculator();
    }

    @Override
    public OrderFreightCalculator createOrderFreightCalculator() {
        return new DefaultOrderFrieightCalculator();
    }

    public PromotionActivityCalculator createOrderPromotionCalculator(){
        return new NoneDiscountOrderPriceCalculator();
    }
}
