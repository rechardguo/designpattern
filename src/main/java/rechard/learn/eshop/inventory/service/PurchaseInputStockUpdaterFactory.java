package rechard.learn.eshop.inventory.service;

import rechard.learn.eshop.domain.PurchaseDto;
import rechard.learn.eshop.inventory.domain.StockDo;

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
