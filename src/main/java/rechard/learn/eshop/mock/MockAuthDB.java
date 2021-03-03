package rechard.learn.eshop.mock;


import rechard.learn.eshop.auth.dao.AccountPriorityDao;
import rechard.learn.eshop.auth.domain.Priority;
import rechard.learn.eshop.auth.domain.PriorityDO;
import rechard.learn.eshop.auth.domain.RoleDO;
import rechard.learn.eshop.domain.Account;

/**
 * 模拟Auth的数据库表
 */
public class MockAuthDB {

    public static  final int purchaseCenter=100;

    /***********************************************************/
    /*   模拟权限                                    */
    /***********************************************************/

    //加供应商Priority
    public static PriorityDO mockAddPurser(){
        PriorityDO p=new PriorityDO();
        p.setId(101);
        p.setCode("addPurchaser");
        p.setUrl("/purchase/add");
        p.setPid(purchaseCenter);
        return p;
    }
    /***********************************************************/
    /*   模拟角色                                       */
    /***********************************************************/
    public static RoleDO mockPurserRole(){
        RoleDO r=new RoleDO();
        r.setId(200);
        //供应商维护者
        r.setCode("purchaser-maintainer");
        r.setName("purchaser-maintainer");
        return r;
    }


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
