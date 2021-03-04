package rechard.learn.eshop.order.service.domain;

import java.util.List;

public class OrderInfoDTO {

    private List<OrderItemInfoDTO> orderItems;

    public List<OrderItemInfoDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemInfoDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
