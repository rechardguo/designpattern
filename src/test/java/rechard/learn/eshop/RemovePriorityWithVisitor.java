package rechard.learn.eshop;

import rechard.learn.eshop.auth.domain.Priority;
import rechard.learn.eshop.auth.service.PriorityService;
import rechard.learn.eshop.mock.MockSpringContext;

/**
 * 实现用visitor模式来实现对权限的删除操作
 */
public class RemovePriorityWithVisitor {

    public static void main(String[] args) {
        int priorityId=100;
        PriorityService service= MockSpringContext.Default.get(PriorityService.class);
        Priority priority=service.findByPriorityId(priorityId);
        try {
            service.remove(priorityId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
