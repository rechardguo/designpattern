package rechard.learn.eshop.mock.spring;

public class Mouse {
    @Autowired
    Cat hunter;

    @Override
    public String toString() {
        return "Mouse{" +
                "hunter=" + hunter +
                '}';
    }
}
