package rechard.learn.designpattern.state;

public class PaymentRejectedState implements PaymentState{
    @Override
    public void approve(Payment payment) {
        System.err.println(payment.getReference()+"is rejected, can not approve");
    }

    @Override
    public void reject(Payment payment) {
        System.err.println(payment.getReference()+"is rejected, can not reject again");
    }

    @Override
    public void stopPayment(Payment payment) {
        System.err.println(payment.getReference()+" can not stop");
    }
}
