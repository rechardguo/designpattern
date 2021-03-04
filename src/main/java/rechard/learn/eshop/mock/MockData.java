package rechard.learn.eshop.mock;


import rechard.learn.eshop.auth.domain.AccountDO;
import rechard.learn.eshop.commodity.domain.CommodityDo;
import rechard.learn.eshop.domain.*;

import java.util.ArrayList;
import java.util.List;

import static rechard.learn.eshop.mock.MockAuthDB.mockPurchaserLucy;
import static rechard.learn.eshop.mock.MockCommodityDB.mockIphone6;
import static rechard.learn.eshop.mock.MockCommodityDB.mockIphone7;
import static rechard.learn.eshop.mock.MockCustomerDB.mockCustomerRechard;


/**
 * 为了简化不写那些mapper,controller而又能写代码而编写的mock数据
 */
public class MockData {




    /**
     * @param purchaser 采购者的账号
     * @param commodityList 商品列表
     * @return 采购列表
     */
    public static List<PurchaseDto> mockPurchaseCommodity(AccountDO purchaser, List<CommodityDo> commodityList){
        List<PurchaseDto> list=new ArrayList<PurchaseDto>();
        for (CommodityDo commodity:commodityList){
            PurchaseDto purchaseDto=new PurchaseDto();
            purchaseDto.setPurchaserId(purchaser.getId());
            purchaseDto.setPurchaserName(purchaser.getEmployName());
            purchaseDto.setSkuId(commodity.getSkuId());
            purchaseDto.setPurchaserName("iphone6");
            purchaseDto.setPurchaserId(commodity.getId());
            purchaseDto.setPurchaseQuantity(MyRandom.random());
            list.add(purchaseDto);
        }
        return list;
    }

    /**
     * 模拟客户下订单
     * @param customer
     * @param commodity
     * @return
     */
    public static OrderDto mockSumitOrder(CustomerDo customer, CommodityDo commodity){
        OrderDto orderDto=new OrderDto();

        orderDto.setCustomerId(customer.getId());
        orderDto.setCustomerName(customer.getCustomerName());

        orderDto.setSkuId(commodity.getSkuId());
        orderDto.setSkuName(commodity.getName());
        orderDto.setQuantity(2);
        return orderDto;
    }

    /**
     * 客户下订单
     * @return
     */
    public static OrderDto mockDataFromCustomer() {
        CustomerDo rechard= mockCustomerRechard();
        CommodityDo iphone6=mockIphone6();
        return mockSumitOrder(rechard,iphone6);
    }



    /**
     * 从采购中心拿到的数据
     * @return
     */
    public static List<PurchaseDto> mockDataFromPurchaseCenter() {
        AccountDO lucy= mockPurchaserLucy();
        CommodityDo purchaseIphone6=mockIphone6();
        CommodityDo purchaseIphone7=mockIphone7();
        List<CommodityDo> commodityList=new ArrayList();
        commodityList.add(purchaseIphone6);
        commodityList.add(purchaseIphone7);
        return MockData.mockPurchaseCommodity(lucy,commodityList);
    }




}


