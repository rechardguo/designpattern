package rechard.learn.eshop.commodity.status;

import rechard.learn.eshop.commodity.constant.GoodState;
import rechard.learn.eshop.commodity.domain.GoodsDTO;

/**
 * @author Rechard
 **/
public class PutOnShelfStatus  implements GoodStauts{
    @Override
    public boolean canEdit(GoodsDTO goods) {
        return false;
    }

    @Override
    public boolean canRemove(GoodsDTO goods) {
        return false;
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
        return false;
    }

    @Override
    public boolean canPutOffShelfApprove(GoodsDTO goods) {
        return false;
    }

    @Override
    public boolean canPutOffshelf(GoodsDTO goods) {
        return true;
    }

    @Override
    public void doTransition(GoodsDTO goods) throws Exception {
        goods.setStatus(GoodState.PutOffShelf.code());
    }
}
