package rechard.learn.eshop.schedule.service;

import rechard.learn.eshop.mock.spring.Autowired;
import rechard.learn.eshop.order.service.domain.OrderInfoDTO;
import rechard.learn.eshop.wms.WmsService;
import rechard.learn.eshop.wms.domain.SaleDeliveryOrderDTO;

public class SaleDeliveryOrderBuilder {

    @Autowired
    WmsService wmsService;

    /**
     *调度销售出库
     * @param order 订单
     * @return 处理结果
     */
    public Boolean scheduleSaleDelivery(OrderInfoDTO order) {
        SaleDeliveryOrderDTO saleDeliveryOrder =null;

        wmsService.createSaleDeliveryOrder(saleDeliveryOrder);
        return true;
    }

}

