package rechard.learn.eshop.mock.spring;

public class Main {
    public static void main(String[] args) throws Exception {
        Cat cat=(Cat)Context.get(Cat.class);
        System.out.println(cat);
    }
}
