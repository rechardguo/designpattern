package rechard.learn.inventory.service;

import rechard.learn.data.mock.MockInventoryDB;
import rechard.learn.inventory.domain.StockDo;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象的工厂方法
 * 这里放了一些通用的逻辑更新库存状态
 */
public abstract  class AbstractStockUpdaterFactory<T> implements StockUpdaterFactory{
    T params ;

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }
    //public AbstractStockUpdaterFactory(T params) {
     //   this.params = params;
   // }

    /**
     * 将通用逻辑放这里
     * @return
     */
    public StockUpdater create() {
        //下面的2步逻辑是基本上都要的，如果都放在具体逻辑里去写的话，就会非常的冗余
        //获取商品的ksuIds集合
        List<Integer> skuIds=getGoodsStockSkuIds(params);
        //取得待更新商品的do
        List<StockDo> list=createStockDos(skuIds);

        return create(list,this.params);
    }

    private  List<StockDo> createStockDos(List<Integer> skuIds){
        //通用的通过skuIds来获取的 List<StockDo>
        List<StockDo> list=new ArrayList<StockDo>();
        //这里模拟根据skuIds从数据库里查出StockDo集合或先插入不存在的StockDo
        for(Integer skuId:skuIds){
            StockDo stockDo=MockInventoryDB.findBySkuId(skuId);
            list.add(stockDo);
        }
        return list;
    }
    //这里更加的具体，一个是库存的对象，一个传进来的参数
    //List<StockDo> list的获取已经由create()里封装好了
    protected abstract StockUpdater create(List<StockDo> list, T params);
    protected abstract List<Integer> getGoodsStockSkuIds(T params) ;
}
