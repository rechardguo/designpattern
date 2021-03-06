package rechard.learn.eshop.order.service;

/**
 *计算订单价格的工厂
 *
 *
 */
public interface OrderPriceCalculateFactory {

    /**
     * 得到订单的价格计算器
     * @return
     */
    public OrderPriceCalculator createOrderPriceCalculator();

    /**
     * 得到运费计算器
     * @return
     */
    public OrderFreightCalculator createOrderFreightCalculator();

    /**
     * 得到促销价格计算器
     * @return
     */
    public PromotionActivityCalculator createOrderPromotionCalculator();

}
