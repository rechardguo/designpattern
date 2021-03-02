package rechard.learn.data.mock;

import java.util.Random;

/**
 * 产生1个100以内的随机数
 */
public class MyRandom {

    static  Random r=new Random();
    public static int random() {
        return 1+r.nextInt(100);
    }
}

