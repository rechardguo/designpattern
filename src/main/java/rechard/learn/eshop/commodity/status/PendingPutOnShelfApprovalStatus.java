package rechard.learn.eshop.commodity.status;

import rechard.learn.eshop.commodity.domain.GoodsDTO;

import static rechard.learn.eshop.commodity.constant.GoodState.PutOnShelf;

/**
 * @author Rechard
 **/
public class PendingPutOnShelfApprovalStatus implements GoodStauts{

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
        return false;
    }

    @Override
    public boolean canPutOnShelf(GoodsDTO goods) {
        return false;
    }

    @Override
    public boolean canPutOnShelfApprove(GoodsDTO goods) {
        return true;
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
        goods.setStatus(PutOnShelf.code());
    }
}
