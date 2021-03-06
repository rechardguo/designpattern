package rechard.learn.eshop.order.service.domain;

public class OrderItemInfoDTO {

    private int skuId;
    /**
     * 单价
     */
    private double price;
    /**
     * 购买数量
     */
    private int quantity;

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
