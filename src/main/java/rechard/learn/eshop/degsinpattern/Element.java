package rechard.learn.degsinpattern;


import com.alibaba.fastjson.JSON;

public abstract class Element<T extends JSON> {

    private T t;

    public Element(T t) {
        this.t = t;
    }

    public T getElement(){
        return t;
    }

    void replaceHolder(Visitor visistor) {
        visistor.accept(this);
    }
}
