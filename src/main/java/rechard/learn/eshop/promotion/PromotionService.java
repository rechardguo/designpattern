package rechard.learn.eshop.promotion;

import rechard.learn.eshop.promotion.constant.PromotionType;
import rechard.learn.eshop.promotion.domain.PromotionDTO;

/**
 * 促销中心
 *
 * 促销中心 中心返回的促销信息
 *
 * //1 直接折扣
 * {
 *     skuid:"123",
 *     promotionType:"1",
 *     disount:"0.2"
 * }
 *
 * //2 满减
 * [0,100) 不减
 * [100,200) 减10
 * [200,300) 减30
 * 400以后 减40
 *
 *  {
 *     skuid:"123",
 *     promotionType:"2",
 *     stretage:[{
 *        "zone":"[0,100)","discount":0
 *       },{
 *        "zone":"[100,200)","discount":10
 *       },{
 *         "zone":"[200,300)","discount":30
 *       },{
 *          "zone":"[400,~)","discount":60
 *       }]
 * }
 *
 * //多买促销
 * {
 *     skuid:"123",
 *     promotionType:"3",
 *     stretage:[{
 *       "thresholdCount":1,  //1件1折
 *       "discountRate":0.1
 *     },{
 *       "thresholdCount":2,  //2件3折
 *       "discountRate":0.3
 *     }]
 *
 * }
 * thresholdCount
 *
 * // 赠品促销
 * {
 *  skuid:"123",
 *  promotionType:"4",
 *  stretage:[{"skuid":"321","quanlity":1},{"skuid":"212",quanlity:1}]
 * }
 */
public class PromotionService {

    /**
     * 根据skuid来找出促销信息
     * @param skuId
     * @return
     */
    public PromotionDTO getPromotionInfo(int skuId){
        PromotionDTO promotion=new PromotionDTO();
        promotion.setId(1);
        promotion.setSkuId(skuId);
        promotion.setType(PromotionType.DIRECT_DISCOUNT.code());

        String stretage="{\"discount\":\"0.1\"}";
        promotion.setStretage(stretage);
        return promotion;
    }

}
