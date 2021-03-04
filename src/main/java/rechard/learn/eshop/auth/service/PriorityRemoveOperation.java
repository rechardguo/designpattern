package rechard.learn.eshop.auth.service;

import rechard.learn.eshop.auth.dao.PriorityDao;
import rechard.learn.eshop.auth.domain.Priority;
import rechard.learn.eshop.mock.spring.Autowired;

import java.util.List;

/**
 * 权限删除的操作
 */

public class PriorityRemoveOperation extends AbstractPriorityOperation<Boolean> {
    @Autowired
    PriorityDao priorityDao;

    public PriorityRemoveOperation(PriorityDao priorityDao) {
        this.priorityDao = priorityDao;
    }

    /**
     * 查询priority是否被关联了
     * @param priority
     * @return
     */
    protected Boolean doExecute(Priority priority) throws Exception {
        //先处理孩子结点
        /*List<Priority> children=priority.getChildren();
        if(children!=null && !children.isEmpty()){
            for(Priority ch:children){
                ch.operate(this);
            }
        }*/

        //实际上不需要调用上面的，因为在AbstractPriorityOperation已经深度优先了
        //也就是说保证了传入的priority就是叶子结点
        //既然是叶子结点，直接删除就好了
        priorityDao.delete(priority.getId());
        return true;
    }
}
