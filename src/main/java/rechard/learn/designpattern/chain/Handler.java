package rechard.learn.designpattern.chain;

public interface Handler {
    public void process(Request request);
    //使用java8的default默认实现
    default void process(Request jsonObj,
                         HandlerChain chain){
        this.process(jsonObj);
        if(chain!=null)
            chain.process(jsonObj);//链式调用
    }
}
