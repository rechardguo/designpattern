package rechard.learn.eshop.commodity.status;

import rechard.learn.eshop.commodity.constant.GoodState;
import rechard.learn.eshop.commodity.domain.GoodsDTO;

/**
 * @author Rechard
 **/
public class CreateStatus implements GoodStauts{
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
        System.out.println("【商品"+goods.getName()+"当前状态】:"+goods.getStatus());
        goods.setStatus(GoodState.Pending_Approval.code());
        System.out.println("【商品"+goods.getName()+"流转后状态】:"+goods.getStatus());
        System.out.println("调用数据库保存商品");
    }
}
