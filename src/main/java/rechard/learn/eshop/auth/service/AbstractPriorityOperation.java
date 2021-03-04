package rechard.learn.eshop.auth.service;

import rechard.learn.eshop.auth.dao.PriorityDao;
import rechard.learn.eshop.auth.domain.Priority;
import rechard.learn.eshop.auth.domain.PriorityDO;
import rechard.learn.eshop.mock.spring.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPriorityOperation<T> implements PriorityOperation<T>{

    private T result;

    @Autowired
    PriorityDao priorityDao;


    /**
     * 这个其实是深度优先遍历
     *
     * @param priority
     * @return
     * @throws Exception
     */
    public T execute(Priority priority) throws Exception {
        if(priority==null)
            throw new Exception("priority should not be empty!");
        int pid=priority.getId();
        List<PriorityDO> children=priorityDao.findPriorityChildren(pid);
        List<Priority> cloneList=new ArrayList<>();
        for (PriorityDO ch:children){
            Priority p= ch.clone(Priority.class);
            p.operate(this);
            cloneList.add(p);
        }
        this.result=doExecute(priority);
        return this.result;

    }

    protected abstract T doExecute(Priority priority) throws Exception;

}
