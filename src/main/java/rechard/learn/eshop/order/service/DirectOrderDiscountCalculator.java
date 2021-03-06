package rechard.learn.eshop.order.service;

import com.alibaba.fastjson.JSONObject;
import rechard.learn.eshop.order.service.domain.OrderItemInfoDTO;
import rechard.learn.eshop.promotion.domain.PromotionDTO;

/**
 * 直接的折扣计算
 */
public class DirectOrderDiscountCalculator implements PromotionActivityCalculator {


    /* *
     * @param orderItem 商品
     * @return
     */
    public PromotionActivityResult calculate(OrderItemInfoDTO orderItem, PromotionDTO promotion)
            throws Exception{
        String stretage = promotion.getStretage();
        //从stretage里获取折扣的信息
        /*  {
          skuid:"123",
          promotionType:"1",
          disount:"0.2"
          }
       */
        JSONObject jsonObj=(JSONObject)JSONObject.parse(stretage);
        double discount=jsonObj.getDouble("disount");
        PromotionActivityResult result=new PromotionActivityResult();
        result.setDiscountAmount(discount*orderItem.getQuantity()*orderItem.getPrice());
        return result;
    }
}
