package rechard.learn.designpattern.factory.myproject;

/**
 * @author Rechard
 **/
public class Demo {

    static ObjectFactory objectFactory=new ObjectFactoryImpl();

    public static void main(String[] args) throws Exception {
        ServiceA sa=(ServiceA) objectFactory.cretate("serviceA");
        System.out.println(sa.greeting());
        ServiceB sb=(ServiceB) objectFactory.cretate("serviceB");
        System.out.println(sb.sayHi());
        ServiceC sc=(ServiceC) objectFactory.cretate("serviceC");
        System.out.println(sc.sayHi());
    }
}
