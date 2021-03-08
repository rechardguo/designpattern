package rechard.learn.eshop.commodity.status;

import rechard.learn.eshop.commodity.domain.GoodsDTO;

/**
 * 商品的状态
 */
public interface GoodStauts {

    /**
     * 能否编辑
     * @return
     */
    public boolean canEdit(GoodsDTO goods);
    /**
     * 能否删除
     * @return
     */
    public boolean canRemove(GoodsDTO goods);

    /**
     * 能否审核
     * @param goods
     * @return 是否能审核
     * @throws Exception
     */
    public boolean canApprove(GoodsDTO goods) throws Exception;

    /**
     * 能否上架
     * @return
     */
    public boolean canPutOnShelf(GoodsDTO goods);

    /**
     * 能否上架
     * @return
     */
    public boolean canPutOnShelfApprove(GoodsDTO goods);

    /**
     * 能否上架
     * @return
     */
    public boolean canPutOffShelfApprove(GoodsDTO goods);

    /**
     * 能否下架
     * @return
     */
    public boolean  canPutOffshelf(GoodsDTO goods);

    /**
     * 状态的流转
     * @param goods
     * @throws Exception
     */
    void doTransition(GoodsDTO goods) throws Exception;

}
