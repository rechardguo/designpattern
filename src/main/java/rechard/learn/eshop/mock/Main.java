package rechard.learn.eshop.mock;

import rechard.learn.eshop.asyn.StockUpdateQueue;

public class Main {
    public static void main(String[] args) {
        StockUpdateQueue queue=MockSpringContext.Default.get(StockUpdateQueue.class);

    }
}
