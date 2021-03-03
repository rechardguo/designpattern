package rechard.learn.eshop.auth.service;

import rechard.learn.eshop.auth.dao.PriorityDao;
import rechard.learn.eshop.auth.domain.Priority;
import rechard.learn.eshop.mock.spring.Autowired;

import java.util.List;

public abstract class AbstractPriorityOperation<T> implements PriorityOperation<T>{

    private T result;

    @Autowired
    PriorityDao priorityDao;


    @Override
    public T execute(Priority priority) {
        int pid=priority.getId();
        List<Priority> children=priorityDao.findPriorityChildren(pid);

        priority.setChildren(children);

        for (Priority ch:children){
            ch.operate(this);
        }
        this.result=doExecute(priority);
        return this.result;

    }

    protected abstract T doExecute(Priority priority);

}
