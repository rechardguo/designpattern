package rechard.learn.eshop.promotion.constant;

public enum PromotionType {
    //直接折扣，满减，多买折扣，送礼物
    DIRECT_DISCOUNT(1),REACH_DISCOUNT(2),
    BUEMORE_DISCOUNT(3),GIFT_SEND(4);
    int code;

    PromotionType(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
