package rechard.learn.eshop.mock;


import rechard.learn.eshop.domain.Account;

/**
 * 模拟Auth的数据库表
 */
public class MockAuthDB {


    /***********************************************************/
    /*   模拟采购专员数据                                         */
    /***********************************************************/
    //模拟采购人员-Lucy
    public static Account mockPurchaserLucy(){
        Account acct=new Account();
        acct.setId(1);
        acct.setRoleName("purchaser");
        acct.setName("purchaser-lucy");
        return acct;
    }
}
