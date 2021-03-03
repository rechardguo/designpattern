package rechard.learn.eshop.mock.spring;

public class Cat{
    @Autowired
    public Mouse food;

    @Override
    public String toString() {
        return "Cat{" +
                "food=" +food +
                '}';
    }
}