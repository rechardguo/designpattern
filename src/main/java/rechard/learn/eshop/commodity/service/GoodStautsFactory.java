package rechard.learn.eshop.commodity.service;

import rechard.learn.eshop.commodity.constant.GoodState;
import rechard.learn.eshop.commodity.domain.GoodsDTO;
import rechard.learn.eshop.commodity.status.*;

/**
 * @author Rechard
 **/
public class GoodStautsFactory {

    /**
     * @param good
     * @return 商品的状态类
     */
    public GoodStauts getGoodStatus(GoodsDTO good) throws Exception {
        GoodState state=GoodState.valueOf(good.getStatus());
        if(state!=null){
            if(state==GoodState.Created){
                return new CreateStatus();
            }else if(state==GoodState.Pending_Approval){
                return new PendingApproveStatus();
            }else if(state==GoodState.Pending_PutOnShelf_approval){
                return new PendingPutOnShelfApprovalStatus();
            }else if(state==GoodState.PutOnShelf_Rejected){
                return new PutOnShelfRejectedStatus();
            }
        }else{
            throw new Exception("can not find good status,good status now is "+good.getStatus());
        }
        return null;
    }

}
