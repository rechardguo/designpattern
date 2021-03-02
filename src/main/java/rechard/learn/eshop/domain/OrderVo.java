package rechard.learn.eshop.domain;

/**
 * 客户下订单的Order对象
 */
public class OrderVo {

    private int id;
    private int skuId;
    private String customerName;
    private int customerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                "id=" + id +
                ", skuId=" + skuId +
                ", customerName='" + customerName + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
