package rechard.learn.designpattern.state;

public interface PaymentState {
    default public void approve(Payment payment){};
    default public void reject(Payment payment){};
    default public void stopPayment(Payment payment){};
}
