package rechard.learn.designpattern.chain;

public class PaymentHandler implements Handler{
    @Override
    public void process(Request request) {
        System.out.println("payment approve:"+request.getReference());
    }
}
