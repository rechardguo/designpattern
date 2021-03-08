package rechard.learn.eshop.commodity.status;

import rechard.learn.eshop.commodity.constant.GoodState;
import rechard.learn.eshop.commodity.domain.GoodsDTO;

/**
 * @author Rechard
 **/
public class ApproveRejectStatus  implements GoodStauts{
    @Override
    public boolean canEdit(GoodsDTO goods) {
        return true;
    }

    @Override
    public boolean canRemove(GoodsDTO goods) {
        return true;
    }

    @Override
    public boolean canApprove(GoodsDTO goods) throws Exception {
        return true;
    }

    @Override
    public boolean canPutOnShelf(GoodsDTO goods) {
        return false;
    }

    @Override
    public boolean canPutOnShelfApprove(GoodsDTO goods) {
        return false;
    }

    @Override
    public boolean canPutOffShelfApprove(GoodsDTO goods) {
        return false;
    }

    @Override
    public boolean canPutOffshelf(GoodsDTO goods) {
        return false;
    }

    @Override
    public void doTransition(GoodsDTO goods) throws Exception {
        goods.setStatus(GoodState.Rejected.code());
    }
}
