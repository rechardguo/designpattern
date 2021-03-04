package rechard.learn.eshop.auth.dao;

import rechard.learn.eshop.auth.domain.Priority;
import rechard.learn.eshop.auth.domain.PriorityDO;
import rechard.learn.eshop.mock.MockAuthDB;
import rechard.learn.eshop.mock.spring.Autowired;

import java.util.List;

public class PriorityDao {

    @Autowired
    MockAuthDB mockAuthDB;

    public List<PriorityDO> findPriorityChildren(int id){
        return null;
    }

    /**
     * 根据权限id删除权限
     * @param id
     */
    public void delete(int id) {
    }

    public PriorityDO findPriority(int priorityId) {
      PriorityDO priorityDO=mockAuthDB.table_Priority.get(priorityId);
      return priorityDO;
    }
}
