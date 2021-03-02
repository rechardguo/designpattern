package rechard.learn.data.mock;

import rechard.learn.asyn.domain.StockUpdateMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 模拟离线消息存储的数据库表
 */
public class MockoffilineStockUpdateMsgStorageDB {

    static List<StockUpdateMessage> list=new ArrayList();

    /**
     * 模拟保存操作
     */
    public static void save(StockUpdateMessage msg){
        list.add(msg);
    }

    public static int count(){
        return list.size();
    }

    /**
     *
     * @param nums 取出消息的条数
     * @return
     */
    public static List<StockUpdateMessage> fetch(int nums){
        if(list.size()<nums){
            return list;
        }else{
            List<StockUpdateMessage> cut=new ArrayList<StockUpdateMessage>();
            System.arraycopy(list,0,cut,0,nums);
            list.removeAll(cut);
            return cut;
        }
    }
}
