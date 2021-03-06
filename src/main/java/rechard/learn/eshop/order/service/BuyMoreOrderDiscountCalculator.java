package rechard.learn.eshop.order.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import rechard.learn.eshop.order.service.domain.OrderItemInfoDTO;
import rechard.learn.eshop.promotion.domain.PromotionDTO;

import java.util.Iterator;

/**
 * 直接的折扣计算
 */
public class BuyMoreOrderDiscountCalculator implements PromotionActivityCalculator {
    /* *
     * @param orderItem 商品
     * @return 促销的结果
     */
    public PromotionActivityResult calculate(OrderItemInfoDTO orderItem, PromotionDTO promotion)
            throws Exception{
        PromotionActivityResult result=new PromotionActivityResult();
        return result;
    }

    /**
     * 判断下是否落在zone的区间
     * @param zone
     * @return
     */
    private boolean isAmountBetweenZone(String zone,double totalAmount) {
        boolean flag=false;
        char leftBound=zone.charAt(0);
        char rightBound=zone.charAt(zone.length()-1);
        String min=zone.substring(1,zone.indexOf(","));
        double minVal=Double.parseDouble(min);

        String max=zone.substring(zone.indexOf(",")+1,zone.length()-1);
        double maxVal=Double.parseDouble(max);

        if(leftBound=='('){
            flag&=(totalAmount>minVal);
        }else{
            flag&=(totalAmount>=minVal);
        }
        if(rightBound==')'){
            flag&=(totalAmount<maxVal);
        }else{
            flag&=(totalAmount<=maxVal);
        }

        return flag;
    }
}
