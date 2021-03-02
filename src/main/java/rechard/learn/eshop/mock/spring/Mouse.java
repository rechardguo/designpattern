package rechard.learn.eshop.mock.spring;

public class Mouse {
    Cat hunter=(Cat)Context.get(Cat.class);

    @Override
    public String toString() {
        return "Mouse{" +
                "hunter=" + hunter +
                '}';
    }
}
