package rechard.learn.designpattern.state;

public class PaymentPendingState implements PaymentState{
    @Override
    public void approve(Payment payment) {
        System.out.println(payment.getReference()+" approved");
        payment.setState(1);
    }

    @Override
    public void reject(Payment payment) {
        System.out.println(payment.getReference()+" rejected");
        payment.setState(7);
    }

    @Override
    public void stopPayment(Payment payment) {
        System.err.println(payment.getReference()+" can not stop");
    }
}
