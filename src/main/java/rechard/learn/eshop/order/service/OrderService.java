package rechard.learn.eshop.order.service;

import rechard.learn.eshop.mock.spring.Autowired;
import rechard.learn.eshop.order.service.domain.OrderInfoDTO;
import rechard.learn.eshop.order.service.domain.OrderItemInfoDTO;
import rechard.learn.eshop.promotion.PromotionService;
import rechard.learn.eshop.promotion.constant.PromotionType;
import rechard.learn.eshop.promotion.domain.PromotionDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单service
 */
public class OrderService {

    @Autowired
    PromotionService promotionService;

    public OrderInfoDTO calculaterOrderPrice(OrderInfoDTO order) throws Exception {
        //正常的订单价格
        double normalOrderPrice=0.0;
        //运费价格
        double freightPrice=0.0;
        //折扣价格
        double discountPrice=0.0;
        List<OrderItemInfoDTO> giftItems=new ArrayList<>();
        List<OrderItemInfoDTO> items=order.getOrderItems();
        for(OrderItemInfoDTO item:items){
            //从促销中心里获得促销的信息
            PromotionDTO promotion=promotionService.getPromotionInfo(item.getSkuId());

            //根据promotion的信息来获取折扣的组合工厂
            OrderPriceCalculateFactory opcf=getOrderPriceCalculateFactory(promotion);
            OrderPriceCalculator orderPriceCalculator=opcf.createOrderPriceCalculator();
            OrderFreightCalculator orderFreightCalculator=opcf.createOrderFreightCalculator();
            PromotionActivityCalculator promotionActivityCalculator
                    =opcf.createOrderPromotionCalculator();

            normalOrderPrice+=orderPriceCalculator.calculate(item);

            PromotionActivityResult result=promotionActivityCalculator.calculate(item,promotion);
            freightPrice+=orderFreightCalculator.calculate(item,result);

            discountPrice+=result.getDiscountAmount();
        }

        order.setNormalOrderPrice(normalOrderPrice);
        order.setDiscountPrice(discountPrice);
        order.setFreightPrice(freightPrice);
        order.getOrderItems().addAll(giftItems);
        return order;
    }

    /**
     * 根据促销的类型来选择订单价格计算工厂
     * @param promotion
     * @return
     */
    private OrderPriceCalculateFactory getOrderPriceCalculateFactory(PromotionDTO promotion) {
        if(promotion==null) {
            return new DefaultOrderPriceCalculateFactory();
        }
        int promotionType=promotion.getType();
        if(promotionType == PromotionType.DIRECT_DISCOUNT.code()){
            return new DirectDiscountOrderPriceCalculateFactory();
        }else if(promotionType == PromotionType.REACH_DISCOUNT.code()){
            return new ReachDiscountOrderPriceCalculateFactory();
        }else if(promotionType == PromotionType.BUEMORE_DISCOUNT.code()){

        }else if(promotionType==PromotionType.GIFT_SEND.code()){
            return new SendGiftOrderPriceCalculateFactory();
        }
        return new DefaultOrderPriceCalculateFactory();

    }
}
