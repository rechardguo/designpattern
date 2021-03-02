package rechard.learn.eshop.domain;

/**
 * 订单dto
 */
public class OrderDto {
    private int customerId;
    private String customerName;
    private int skuId;
    private String skuName;
    //订单ID
    private int orderId;
    //购买商品的数量
    private int quantity;
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", skuId=" + skuId +
                ", skuName='" + skuName + '\'' +
                ", orderId=" + orderId +
                ", quantity=" + quantity +
                '}';
    }
}
