package rechard.learn.eshop.mock;


import rechard.learn.eshop.commodity.domain.CommodityDo;

/**
 * 模拟商品中心的数据库表
 */
public class MockCommodityDB {

    /**
     * 模拟商品iphone6
     * @return
     */
    public static CommodityDo mockIphone6(){
        CommodityDo commodityDo=new CommodityDo();
        commodityDo.setId(1);
        commodityDo.setName("iphone 6");
        commodityDo.setSkuId(123);
        return commodityDo;
    }

    /**
     * 模拟商品iphone7
     * @return
     */
    public static CommodityDo mockIphone7(){
        CommodityDo commodityDo=new CommodityDo();
        commodityDo.setId(2);
        commodityDo.setName("iphone 7");
        commodityDo.setSkuId(321);
        return commodityDo;
    }


}
