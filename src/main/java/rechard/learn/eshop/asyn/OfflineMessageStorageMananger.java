package rechard.learn.eshop.asyn;


import rechard.learn.eshop.asyn.domain.StockUpdateMessage;
import rechard.learn.eshop.mock.MockoffilineStockUpdateMsgStorageDB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OfflineMessageStorageMananger {

    private volatile boolean offline=false;
    public boolean isOffline() {
        return offline;
    }
    public void setOffline(boolean offline) {
        this.offline = offline;
    }

    public int count(){
        return MockoffilineStockUpdateMsgStorageDB.count();
    }

    public List<StockUpdateMessage> fetchBatch(){
        return MockoffilineStockUpdateMsgStorageDB.fetch(100);
    }

    public Iterator<List<StockUpdateMessage>> iterator(){
        return new OfflineMessageStorageManangerIterator(this);
    }
    static class OfflineMessageStorageManangerIterator implements Iterator<List<StockUpdateMessage>>{
        private OfflineMessageStorageMananger mgr;
        private List<StockUpdateMessage> msgList =new ArrayList();

        public OfflineMessageStorageManangerIterator(OfflineMessageStorageMananger mgr){
            this.mgr=mgr;
        }
        @Override
        public boolean hasNext() {
           return mgr.count()>0;
        }

        @Override
        public List<StockUpdateMessage> next() {
            return  mgr.fetchBatch();
        }
    }
}
