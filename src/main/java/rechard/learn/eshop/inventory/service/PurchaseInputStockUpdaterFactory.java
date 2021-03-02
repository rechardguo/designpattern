package rechard.learn.inventory.service;

import rechard.learn.purchase.domain.PurchaseDto;
import rechard.learn.inventory.domain.StockDo;

import java.util.ArrayList;
import java.util.List;

public class PurchaseInputStockUpdaterFactory extends AbstractStockUpdaterFactory <List<PurchaseDto>>{
    /*public PurchaseInputStockUpdaterFactory(List<PurchaseDto> pList) {
        super(pList);
    }*/

    @Override
    protected StockUpdater create(List<StockDo> list, List<PurchaseDto> pList) {
        return new PurchaseInputStockUpdater(list,pList);
    }

    @Override
    protected List<Integer> getGoodsStockSkuIds(List<PurchaseDto> purchaseList) {
        List stockList=new ArrayList();
        for(PurchaseDto p:purchaseList){
            stockList.add(p.getSkuId());
        }
        return stockList;
    }
}
