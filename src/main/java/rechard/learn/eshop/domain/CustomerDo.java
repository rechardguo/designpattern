package rechard.learn.eshop.domain;

/**
 * 注册的客户对象
 * 简化，没有邮箱，地址等等，只为了使得流程能跑通
 */
public class CustomerDo {
    private int id;
    private int customerID;
    private String customerName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
