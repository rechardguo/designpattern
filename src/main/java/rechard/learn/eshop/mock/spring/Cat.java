package rechard.learn.eshop.mock.spring;

public class Cat{

    Mouse food=(Mouse)Context.get(Mouse.class);

    @Override
    public String toString() {
        return "Cat{" +
                "food=" +food +
                '}';
    }
}