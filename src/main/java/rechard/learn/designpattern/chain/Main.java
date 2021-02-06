package rechard.learn.designpattern.chain;

public class Main {

    public static void main(String[] args) {
        Request request=new Request("12345","new payment need approve");
        HandlerChain chain=new HandlerChain();
        chain.addHandler(new LogHandler());
        chain.addHandler(new PaymentHandler());
        chain.process(request);
    }
}
