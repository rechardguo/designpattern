package rechard.learn.designpattern.factory;

import java.util.PriorityQueue;

public class WithoutAbstractFactoryDemo {
    public static void main(String[] args) {
        Product productA1=new ProductA1();
        Product productB2=new ProductB2();
        productA1.execute();
        productB2.execute();

        //现在要讲A1+B2改成A1+B1组合如下


        Product otherProductA1=new ProductA1();
        Product ohterProductB1=new ProductB1();
        otherProductA1.execute();
        ohterProductB1.execute();

    }

    public static interface Product{
        public void execute();
    }

    public static class ProductA1 implements Product{
        @Override
        public void execute() {
            System.out.println("productA1 execute");
        }
    }


    public static class ProductA2 implements Product{
        @Override
        public void execute() {
            System.out.println("productA2 execute");
        }
    }

    public static class ProductB1 implements Product{
        @Override
        public void execute() {
            System.out.println("productB1 execute");
        }
    }


    public static class ProductB2 implements Product{
        @Override
        public void execute() {
            System.out.println("productB2 execute");
        }
    }

    public static class ProductC1 implements Product{
        @Override
        public void execute() {
            System.out.println("productC1 execute");
        }
    }


    public static class ProductC2 implements Product{
        @Override
        public void execute() {
            System.out.println("productC2 execute");
        }
    }

}
