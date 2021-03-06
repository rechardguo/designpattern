package rechard.learn.eshop.order.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import rechard.learn.eshop.order.service.domain.OrderItemInfoDTO;
import rechard.learn.eshop.promotion.domain.PromotionDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * 送礼物促销计算器
 *
 */
public class SendGiftPromotionCalculator implements PromotionActivityCalculator {
    public static void main(String[] args) {
        String str="[{\"skuid\":\"321\",\"quanlity\":1},{\"skuid\":\"212\",quanlity:1}]";
        JSONArray arr=JSON.parseArray(str);
        for(int i=0;i<arr.size();i++){
            JSONObject gift=(JSONObject) arr.get(i);
            System.out.println(gift.getString("skuid"));
        }
    }

    /* *
     * @param orderItem 商品
     * @return
     */
    public PromotionActivityResult calculate(OrderItemInfoDTO orderItem, PromotionDTO promotion)
            throws Exception{
        String stretage = promotion.getStretage();
        /**
         *  * {
         *  *  skuid:"123",
         *  *  promotionType:"4",
         *  *  stretage:[{"skuid":"321","quanlity":1},{"skuid":"212",quanlity:1}]
         *  * }
         */
        PromotionActivityResult result=new PromotionActivityResult();
        JSONArray jsonArr=JSON.parseArray(stretage);
        List<OrderItemInfoDTO> gifts=new ArrayList<>();
        for(int i=0;i<jsonArr.size();i++){
            JSONObject gift=(JSONObject) jsonArr.get(i);
            int skuId=gift.getInteger("skuid");
            OrderItemInfoDTO item=new OrderItemInfoDTO();
            item.setSkuId(skuId);
            item.setPrice(0.0); // 赠品的价格当然是0
            item.setQuantity(gift.getInteger("quantity"));
            gifts.add(item);
        }
        result.setGifts(gifts);
        return result;
    }

}
