package rechard.learn.designpattern.chain;

public class LogHandler implements Handler {
    public void process(Request request) {
        System.out.println("payment ref:"+request.getReference());
    }
}
