package rechard.learn.eshop.order.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import rechard.learn.eshop.order.service.domain.OrderItemInfoDTO;
import rechard.learn.eshop.promotion.domain.PromotionDTO;

import java.util.Iterator;

/**
 * 直接的折扣计算
 */
public class ReachOrderDiscountCalculator implements PromotionActivityCalculator {
    /* *
     * @param orderItem 商品
     * @return
     */
    public PromotionActivityResult calculate(OrderItemInfoDTO orderItem, PromotionDTO promotion)
            throws Exception{
        String stretage = promotion.getStretage();
        //从stretage里获取折扣的信息
        /**
         *  *  {
         *  *     skuid:"123",
         *  *     promotionType:"2",
         *  *     stretage:[{
         *  *        "zone":"[0,100)","discount":0
         *  *       },{
         *  *        "zone":"[100,200)","discount":10
         *  *       },{
         *  *         "zone":"[200,300)","discount":30
         *  *       },{
         *  *          "zone":"[400,~)","discount":60
         *  *       }]
         *  * }
         */
        PromotionActivityResult result=new PromotionActivityResult();
        double totalAmount= orderItem.getQuantity()*orderItem.getPrice();
        JSONArray jsonArr=(JSONArray)JSONObject.parse(stretage);
        Iterator it=jsonArr.iterator();
        while(it.hasNext()){
            JSONObject jsonObject=(JSONObject) it.next();
            String zone=jsonObject.getString("zone");
            if(isAmountBetweenZone(zone,totalAmount)){

                if(result.getDiscountAmount()<jsonObject.getDouble("discount")){
                    result.setDiscountAmount(jsonObject.getDouble("discount"));
                }
            }
        }

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
