package rechard.learn.eshop;

import rechard.learn.eshop.asyn.StockUpdateQueue;
import rechard.learn.eshop.commodity.domain.GoodsDTO;
import rechard.learn.eshop.commodity.service.GoodService;
import rechard.learn.eshop.mock.MockSpringContext;

/**
 * @author Rechard
 *
 * 利用状态管理模式来完成商品的流程管理
 **/
public class GoodsManageFlowWithStatus {
    public static void main(String[] args) throws Exception {
        // create goods
        GoodService service= MockSpringContext.Default.get(GoodService.class);
        GoodsDTO good=new GoodsDTO();
        good.setId(1);
        good.setName("iphone7");
        good.setSkuId(123);
        service.create(good);

        //审批通过
        service.approve(good);
        service.reject(good);
    }
}
