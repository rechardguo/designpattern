package rechard.learn.eshop.domain;

public class PurchaseDto {
    //采购专员id
    private int purchaserId;
    //采购专员名
    private String purchaserName;
    //采购商品id
    private int skuId;
    //采购商品名
    private String skuName;
    //采购商品数量
    private int purchaseQuantity;
    public int getSkuId() {
        return skuId;
    }
    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public int getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(int purchaserId) {
        this.purchaserId = purchaserId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }
}
