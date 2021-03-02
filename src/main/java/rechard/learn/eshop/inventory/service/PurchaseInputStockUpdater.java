package rechard.learn.eshop.inventory.service;

import rechard.learn.inventory.domain.StockDo;
import rechard.learn.purchase.domain.PurchaseDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  采购入库的具体Command
 */
public class PurchaseInputStockUpdater extends AbstractStockUpdater{

    //不同的command所获取的数据来源不一定都一样
    //假定这里采购入库订单的数据来源是一个List<Purchase>对象
    private List<PurchaseDto> purchaseList;

    public PurchaseInputStockUpdater(List<StockDo> stockDoList, List<PurchaseDto> purchaseList) {
        super(stockDoList);
        this.purchaseList = purchaseList;
    }

    @Override
    protected void updateSaledStockQuantity() {
    }

    @Override
    protected void updateLockedStockQuantity() {
    }

    @Override
    protected void updateSaleStockQuantity() {
        Map<Integer,PurchaseDto> map=conver2Map(purchaseList);

        for(StockDo stockDo:this.stockDoList){
            PurchaseDto p=map.get(stockDo.getSkuId());
            System.out.println("【采购入库】:商品="+stockDo.getName()+",原销售库存="+stockDo.getSalesQuantity());
            stockDo.setSalesQuantity(stockDo.getSaledQuantity()+p.getPurchaseQuantity());
            System.out.println("【采购入库】:增销售库存,商品="+stockDo.getName()+",销售库存="+stockDo.getSalesQuantity());
        }
    }

    private Map<Integer, PurchaseDto> conver2Map(List<PurchaseDto> purchaseList) {
        Map<Integer, PurchaseDto> m=new HashMap();
        for(PurchaseDto p:purchaseList){
            m.put(p.getSkuId(),p);
        }
        return m;
    }
}
