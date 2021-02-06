package rechard.learn.designpattern.chain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HandlerChain implements Handler {

    List<Handler> handlers;
    private Iterator<Handler> it= null ;
    public HandlerChain() {
        this.handlers = new ArrayList<>();
    }

    public void addHandler(Handler handler){
        this.handlers.add(handler);
    }

    @Override
    public void process(Request request) {
        if(it==null)
          it = this.handlers.iterator();
        if(it.hasNext()){
            Handler nextHandler = it.next();
            //ResponseHandler 接口里的默认实现,java8的default
            //！！！！关键的调用，实现了链式处理
            nextHandler.process(request,this);
        }
    }
}
