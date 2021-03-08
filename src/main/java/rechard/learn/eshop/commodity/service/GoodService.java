package rechard.learn.eshop.commodity.service;

import rechard.learn.eshop.commodity.domain.GoodsDTO;
import rechard.learn.eshop.commodity.status.ApproveRejectStatus;
import rechard.learn.eshop.commodity.status.GoodStauts;
import rechard.learn.eshop.commodity.status.PendingApproveStatus;
import rechard.learn.eshop.mock.spring.Autowired;

/**
 * @author Rechard
 **/
public class GoodService {
    @Autowired
    GoodStautsFactory fac;

    public void create(GoodsDTO good) throws Exception {
        GoodStauts goodStauts=fac.getGoodStatus(good);
        goodStauts.doTransition(good);
    }


    //前端调用 controller  "/approve/approve/{goodsId}
    public void approve(GoodsDTO good) throws Exception {
        GoodStauts goodStauts=fac.getGoodStatus(good);
        if(!goodStauts.canApprove(good)){
            throw new Exception("CAN NOT APPROVE GOODS");
        }
        new PendingApproveStatus().doTransition(good);
    }
    //前端调用 controller  "/approve/reject/{goodsId}
    public void reject(GoodsDTO good) throws Exception {
        GoodStauts goodStauts=fac.getGoodStatus(good);
        if(!goodStauts.canApprove(good)){
            throw new Exception("CAN NOT REJECT GOODS");
        }
        new ApproveRejectStatus().doTransition(good);
    }
}
