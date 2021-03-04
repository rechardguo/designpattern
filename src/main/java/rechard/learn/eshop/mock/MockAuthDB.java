package rechard.learn.eshop.mock;


import rechard.learn.eshop.auth.domain.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟Auth的数据库表
 */
public class MockAuthDB {

    //这里模拟存储表
    public static Map<Integer,PriorityDO> table_Priority=new HashMap<>();
    public static Map<Integer,RoleDO> table_Role=new HashMap<>();
    public static Map<Integer, AccountDO> table_Account_Role=new HashMap<>();
    public static Map<Integer, AccountDO> table_Account=new HashMap<>();
    public static Map<Integer, AccountPriorityDO> table_Account_Priority=new HashMap<>();
    public static Map<Integer, RolePriorityDO> table_Role_Priority=new HashMap<>();

    public static PriorityDO root=mockRootPurser();
    static {
        initPriorityTable();
        initRoleTable();
        initAccountTable();
        initRole_PriorityTable();
    }
    public static void initPriorityTable(){
        PriorityDO p1=mockAddPurser();
        PriorityDO p2=mockAddPurser();
        PriorityDO p3=mockAddPurser();
        table_Priority.put(root.getId(),root);
        table_Priority.put(p1.getId(),p1);
        table_Priority.put(p2.getId(),p2);
        table_Priority.put(p3.getId(),p3);
    }
    public static void initRoleTable(){
        RoleDO pm=mockPurserManagerRole();
        RoleDO pmaintainer=mockPurserMaintainerRole();
        table_Role.put(pm.getId(),pm);
        table_Role.put(pmaintainer.getId(),pmaintainer);
    }

    public static void initAccountTable(){
        RoleDO pm=mockPurserManagerRole();
        AccountDO acct=mockPurchaserLucy();
        table_Account.put(acct.getId(),acct);
    }

    public static void initRole_PriorityTable(){
        RoleDO pm=mockPurserManagerRole();
        PriorityDO p1=mockAddPurser();
        PriorityDO p2=mockAddPurser();
        PriorityDO p3=mockAddPurser();
        RolePriorityDO rolePriorityDO1=new RolePriorityDO();
        rolePriorityDO1.setPriorityId(p1.getId());
        rolePriorityDO1.setRoleId(pm.getId());


        RolePriorityDO rolePriorityDO2=new RolePriorityDO();
        rolePriorityDO2.setPriorityId(p1.getId());
        rolePriorityDO2.setRoleId(pm.getId());


        RolePriorityDO rolePriorityDO3=new RolePriorityDO();
        rolePriorityDO3.setPriorityId(p1.getId());
        rolePriorityDO3.setRoleId(pm.getId());

        table_Role_Priority.put(rolePriorityDO1.getId(),rolePriorityDO1);
        table_Role_Priority.put(rolePriorityDO1.getId(),rolePriorityDO2);
        table_Role_Priority.put(rolePriorityDO1.getId(),rolePriorityDO3);
    }



    public static void initAccont_PriorityTable() {
        AccountDO acct = mockPurchaserLucy();
        PriorityDO p2 = mockAddPurser();
        AccountPriorityDO acctPriorityDO1 = new AccountPriorityDO();
        acctPriorityDO1.setId(100);

    }

    /***********************************************************/
    /*   模拟权限
    /***********************************************************/
    public static PriorityDO mockRootPurser(){
        PriorityDO p=new PriorityDO();
        p.setId(100);
        p.setCode("addPurchaser");
        p.setUrl("/purchase/add");
        p.setPid(1);
        return p;
    }

    //加供应商权限
    public static PriorityDO mockAddPurser(){
        PriorityDO p=new PriorityDO();
        p.setId(101);
        p.setCode("addPurchaser");
        p.setUrl("/purchase/add");
        p.setPid(root.getId());
        return p;
    }

    //删除供应商权限
    public static PriorityDO mockRemovePurser(){
        PriorityDO p=new PriorityDO();
        p.setId(102);
        p.setCode("removePurchaser");
        p.setUrl("/purchase/remove");
        p.setPid(root.getId());
        return p;
    }

    //删除供应商权限
    public static PriorityDO mockEditPurser(){
        PriorityDO p=new PriorityDO();
        p.setId(103);
        p.setCode("editPurchaser");
        p.setUrl("/purchase/edit");
        p.setPid(root.getId());
        return p;
    }
    /***********************************************************/
    /*   模拟角色
    /***********************************************************/
    public static RoleDO mockPurserManagerRole(){
        RoleDO r=new RoleDO();
        r.setId(200);
        //供应商维护者
        r.setCode("purchaser-manager");
        r.setName("purchaser-manager");
        return r;
    }

    public static RoleDO mockPurserMaintainerRole(){
        RoleDO r=new RoleDO();
        r.setId(201);
        //供应商维护者
        r.setCode("purchaser-maintainer");
        r.setName("purchaser-maintainer");
        return r;
    }

    /***********************************************************/
    /*   模拟采购专员数据                                         */
    /***********************************************************/
    //模拟采购人员-Lucy
    public static AccountDO mockPurchaserLucy(){
        AccountDO acct=new AccountDO();
        acct.setId(1);
        acct.setPassword("lucy");
        acct.setUserName("lucy");
        acct.setEmployName("purchaser-1");
        return acct;
    }



}
