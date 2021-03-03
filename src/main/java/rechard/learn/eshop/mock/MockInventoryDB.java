package rechard.learn.eshop.mock;

import rechard.learn.eshop.commodity.domain.CommodityDo;
import rechard.learn.eshop.inventory.domain.StockDo;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟库存的DB
 */
public class MockInventoryDB {

    /**
     * 库存表
     */
    static List<StockDo> table_inventories=new ArrayList();
    /**
     * 离线库存更新消息表
     */
    static List<StockDo> table_offlineMessages=new ArrayList();

    /**
     * 假定只有2个商品
     */
    static {
        CommodityDo iphone6=MockCommodityDB.mockIphone6();
        CommodityDo iphone7=MockCommodityDB.mockIphone7();
        table_inventories.add(convert(iphone6));
        table_inventories.add(convert(iphone7));
    }

    static StockDo convert(CommodityDo commodity){
        StockDo stockDo=new StockDo();
        stockDo.setId(MyRandom.random());
        stockDo.setSkuId(commodity.getSkuId());
        stockDo.setSalesQuantity(MyRandom.random());
        stockDo.setLockQuantity(0);
        stockDo.setName(commodity.getName());
        stockDo.setSaledQuantity(MyRandom.random());
        return stockDo;
    }

    public static StockDo findBySkuId(int skuId){
        for(StockDo s:table_inventories){
            if(s.getSkuId()==skuId){
                return s;
            }
        }
        return null;
    }

}
