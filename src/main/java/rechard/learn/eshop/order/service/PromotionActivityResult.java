package rechard.learn.eshop.order.service;

import rechard.learn.eshop.order.service.domain.OrderItemInfoDTO;

import java.util.List;

public class PromotionActivityResult {

    /**
     * 减免价格
     */
    private double discountAmount;

    /**
     * 赠品
     */
    private List<OrderItemInfoDTO> gifts;

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public List<OrderItemInfoDTO> getGifts() {
        return gifts;
    }

    public void setGifts(List<OrderItemInfoDTO> gifts) {
        this.gifts = gifts;
    }
}
