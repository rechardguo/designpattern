package rechard.learn.designpattern.state;

public class Main {

    public static void main(String[] args) {
        Payment payment=new Payment("123124");
        payment.setState(0);
        PaymentProcessor.getInstance().approve(payment);
    }
}
