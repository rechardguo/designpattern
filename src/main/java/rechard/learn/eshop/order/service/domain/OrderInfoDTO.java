package rechard.learn.eshop.order.service.domain;

import java.util.List;

public class OrderInfoDTO {
    //正常的订单价格
    private double normalOrderPrice;
    //运费价格
    private double freightPrice;
    //折扣价格
    private double discountPrice;

    private List<OrderItemInfoDTO> orderItems;

    public List<OrderItemInfoDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemInfoDTO> orderItems) {
        this.orderItems = orderItems;
    }


    public double getNormalOrderPrice() {
        return normalOrderPrice;
    }

    public void setNormalOrderPrice(double normalOrderPrice) {
        this.normalOrderPrice = normalOrderPrice;
    }

    public double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }
}
