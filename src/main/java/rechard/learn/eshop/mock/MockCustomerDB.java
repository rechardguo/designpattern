package rechard.learn.data.mock;

import rechard.learn.customer.domain.CustomerDo;

/**
 * 模拟客户数据库表
 */
public class MockCustomerDB {

    /***********************************************************/
    /*   模拟客户数据                                            */
    /***********************************************************/
    //模拟客户-Rechard
    public static CustomerDo mockCustomerRechard(){
        CustomerDo c=new CustomerDo();
        c.setCustomerID(1);
        c.setCustomerName("customer-rechard");
        return c;
    }


    //模拟客户-Tom
    public static CustomerDo mockCustomerTom(){
        CustomerDo c=new CustomerDo();
        c.setCustomerID(2);
        c.setCustomerName("customer-tom");
        return c;
    }

}
