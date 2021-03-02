package rechard.learn.eshop.inventory.service;

import rechard.learn.eshop.domain.OrderDto;
import rechard.learn.eshop.inventory.domain.StockDo;

import java.util.List;

/**
 *  客户下订单的具体Command
 *
 *  客户下订单的只是需要updateStep2 和updateStep3
 *
 *  则updateStep1留空
 */
public class SubmitOrderStockUpdater extends AbstractStockUpdater{

    //不同的command所获取的数据来源不一定都一样
    //假定这里客户下订单的数据来源是一个Order 对象
    private OrderDto order;

    public SubmitOrderStockUpdater(List<StockDo> stockDoList, OrderDto order) {
        super(stockDoList);
        this.order = order;
    }

    @Override
    protected void updateSaledStockQuantity() {
        for (StockDo stockDo:stockDoList) {
            stockDo.setSalesQuantity(stockDo.getSalesQuantity()- order.getQuantity());
            System.out.println("【客户下订单】:减销售库存,商品=" + stockDo.getName()
                    + ",销售库存=" + stockDo.getSalesQuantity());
        }
    }

    @Override
    protected void updateLockedStockQuantity() {
        for (StockDo stockDo:stockDoList) {
            stockDo.setLockQuantity(stockDo.getLockQuantity()+order.getQuantity());
            System.out.println("【客户下订单】:增锁定库存,商品=" + stockDo.getName()
                    + ",锁定库存=" + stockDo.getLockQuantity());
        }
    }

    @Override
    protected void updateSaleStockQuantity() {

    }
}
