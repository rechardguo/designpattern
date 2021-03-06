package rechard.learn.eshop.promotion.domain;

/**
 * 促销信息
 */
public class PromotionDTO {

    private int id;
    private int skuId;
    private int type; //促销类型
    private String stretage;//促销的策略信息，json格式

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStretage() {
        return stretage;
    }

    public void setStretage(String stretage) {
        this.stretage = stretage;
    }
}
