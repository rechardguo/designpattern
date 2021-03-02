package rechard.learn.inventory.service;

import rechard.learn.inventory.constant.StockStatus;
import rechard.learn.inventory.domain.StockDo;

import java.util.Date;
import java.util.List;

public abstract class AbstractStockUpdater implements StockUpdater{

    //待更新的stockDoList集合对象
    protected List<StockDo> stockDoList;

    public AbstractStockUpdater(List<StockDo> stockDoList) {
        this.stockDoList = stockDoList;
    }

    /**
     * 定义后了更新的通用方法
     * @return
     */
    @Override
    public boolean update() {
        updateSaleStockQuantity();
        updateLockedStockQuantity();
        updateSaledStockQuantity();
        updateStockStatus();
        updateGmtModified();
        executeUpdateGoodsStock();
        return true;
    }

    /**
     * 批量更新库存
     */
    private void executeUpdateGoodsStock() {
        for(StockDo stockDo:stockDoList){
            System.out.println("【通用逻辑】:更新库存数据库"+stockDo.toString());
        }
    }

    private void updateGmtModified() {
        for(StockDo stockDo:stockDoList){
                stockDo.setGmtUpdateTime(new Date());
                System.out.println("【通用逻辑】:更新时间,商品="+stockDo.getName()+",更新时间为:"+stockDo.getGmtUpdateTime());
        }
    }

    //更新库存状态
    private void updateStockStatus() {
        for(StockDo stockDo:stockDoList){
            if(stockDo.getSalesQuantity()<=0){
                stockDo.setStatus(StockStatus.Empty.value());
                System.out.println("【通用逻辑】:更新库存状态,商品="+stockDo.getName()+"无库存");
            }else{
                stockDo.setStatus(StockStatus.NOT_EMPTY.value());
                System.out.println("【通用逻辑】:更新库存状态,商品="+stockDo.getName()+"有库存");
            }

        }
    }

    protected abstract void updateSaledStockQuantity();

    protected abstract void updateLockedStockQuantity();

    protected abstract void updateSaleStockQuantity();

}
