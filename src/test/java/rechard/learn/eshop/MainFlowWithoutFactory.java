package rechard.learn.eshop;

import rechard.learn.eshop.domain.CommodityDo;
import rechard.learn.eshop.domain.CustomerDo;
import rechard.learn.eshop.domain.OrderDto;
import rechard.learn.eshop.domain.PurchaseDto;
import rechard.learn.eshop.inventory.domain.StockDo;
import rechard.learn.eshop.inventory.service.PurchaseInputStockUpdater;
import rechard.learn.eshop.inventory.service.StockUpdater;
import rechard.learn.eshop.inventory.service.SubmitOrderStockUpdater;
import rechard.learn.eshop.mock.MockData;

import java.util.ArrayList;
import java.util.List;

import static rechard.learn.eshop.mock.MockCommodityDB.mockIphone6;
import static rechard.learn.eshop.mock.MockCustomerDB.mockCustomerRechard;
import static rechard.learn.eshop.mock.MockData.mockDataFromPurchaseCenter;


/**
 * 如果没有工厂方法，那封装的具体的Command的逻辑就放到了具体的类
 * 看下面的参数转换的过程，而如果这里面其实有共同的逻辑
 */
public class MainFlowWithoutFactory {

    public static void main(String[] args) {

        OrderDto customerOrder=mockDataFromCustomer();

        // customerOrder 转成为SubmitOrderStockUpdater里所需要的参数
        List<StockDo> stockDoList=new ArrayList<StockDo>();
        StockDo stockDo =new StockDo();
        stockDo.setSkuId(customerOrder.getSkuId());
        stockDoList.add(stockDo);

        StockUpdater submitOrderStockUpdater=new SubmitOrderStockUpdater(stockDoList,customerOrder);
        submitOrderStockUpdater.update();

        List<PurchaseDto> puchaseList = mockDataFromPurchaseCenter();
        StockUpdater purcharseInputStockUpdater=new PurchaseInputStockUpdater(stockDoList,puchaseList);
        purcharseInputStockUpdater.update();

    }


    /**
     * 客户下订单
     * @return
     */
    private static OrderDto mockDataFromCustomer() {
        CustomerDo rechard= mockCustomerRechard();
        CommodityDo iphone6=mockIphone6();
        return MockData.mockSumitOrder(rechard,iphone6);
    }





}
