package rechard.learn.eshop.auth.service;

import rechard.learn.eshop.auth.dao.AccountPriorityDao;
import rechard.learn.eshop.auth.dao.PriorityDao;
import rechard.learn.eshop.auth.dao.RolePriorityDao;
import rechard.learn.eshop.auth.domain.Priority;
import rechard.learn.eshop.auth.domain.PriorityDO;
import rechard.learn.eshop.mock.spring.Autowired;
import rechard.learn.eshop.utils.BeanCopierUtils;

public class PriorityService {
    @Autowired
    AccountPriorityDao accountPriorityDao;
    @Autowired
    RolePriorityDao rolePriorityDao;
    @Autowired
    PriorityDao priorityDao;

    public Priority findByPriorityId(int priorityId){
        PriorityDO priorityDO=priorityDao.findPriority(priorityId);
        Priority priority=new Priority();
        BeanCopierUtils.copy(priorityDO,priority);
        return priority;
    }

    /**
     * 删除某个权限
     * @param priorityId 权限id
     */
    public void remove(int priorityId) throws Exception {
        Priority priority=findByPriorityId(priorityId);

        PriorityOperation<Boolean> priorityRelatedOperation
                =new PriorityRelatedOperation(accountPriorityDao,rolePriorityDao);
        //1. 查权限是否被关联了
       if(priorityRelatedOperation.execute(priority)){
           //2. 如果有就放弃，抛出异常
           throw new Exception("priority 被账号或角色关联，不能删除");
       }
        //3. 如果没有就删除
        PriorityOperation<Boolean> priorityRemoveOperation =
                new PriorityRemoveOperation(priorityDao);

        priorityRemoveOperation.execute(priority);
    }

}
