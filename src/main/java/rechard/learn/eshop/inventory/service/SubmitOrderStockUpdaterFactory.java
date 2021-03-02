package rechard.learn.inventory.service;

import rechard.learn.customer.domain.OrderDto;
import rechard.learn.inventory.domain.StockDo;

import java.util.ArrayList;
import java.util.List;

public class SubmitOrderStockUpdaterFactory extends AbstractStockUpdaterFactory<OrderDto>{
   /* public SubmitOrderStockUpdaterFactory(OrderDto params) {
        super(params);
    }*/

    @Override
    protected  StockUpdater create(List<StockDo> list, OrderDto order) {
        return new SubmitOrderStockUpdater(list,order);
    }


    @Override
    protected List<Integer> getGoodsStockSkuIds(OrderDto order) {
        List<Integer> list=new ArrayList<Integer>();
        list.add(params.getSkuId());
        return list;
    }
}
