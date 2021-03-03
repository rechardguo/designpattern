package rechard.learn.eshop.auth.service;

import rechard.learn.eshop.auth.dao.AccountPriorityDao;
import rechard.learn.eshop.auth.dao.RolePriorityDao;
import rechard.learn.eshop.auth.domain.Priority;
import rechard.learn.eshop.auth.domain.RolePriorityRelationshipDO;
import rechard.learn.eshop.mock.spring.Autowired;

/**
 * 权限是否被关联的操作
 */

public class PriorityRelatedOperation extends AbstractPriorityOperation<Boolean> {
    @Autowired
    AccountPriorityDao accountPriorityDao;
    @Autowired
    RolePriorityDao rolePriorityDao;

    public PriorityRelatedOperation(AccountPriorityDao accountPriorityDao, RolePriorityDao rolePriorityDao) {
        this.accountPriorityDao = accountPriorityDao;
        this.rolePriorityDao = rolePriorityDao;
    }

    /**
     * 查询priority是否被关联了
     * @param priority
     * @return
     */
    protected Boolean doExecute(Priority priority) {
        //获取到关联到priority的账号个数
        int priorityRelatedAcctCount=accountPriorityDao.countByPriorityId(priority.getId());
        if(priorityRelatedAcctCount>0)
            return false;

        //获取到关联到priority的角色个数
        int priorityRelatedRoleCount=rolePriorityDao.countByPriorityId(priority.getId());
        if(priorityRelatedRoleCount>0)
            return false;

        return true;
    }
}
