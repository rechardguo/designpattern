package rechard.learn.eshop.inventory.domain;

import java.util.Date;

public class StockDo {
    private int id;
    private int skuId;
    //商品名
    private String name;
    private int salesQuantity;
    private int saledQuantity;
    private int lockQuantity;
    private int status;
    private Date gmtCreateTime;
    private Date gmtUpdateTime;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public int getSaledQuantity() {
        return saledQuantity;
    }

    public void setSaledQuantity(int saledQuantity) {
        this.saledQuantity = saledQuantity;
    }

    public int getLockQuantity() {
        return lockQuantity;
    }

    public void setLockQuantity(int lockQuantity) {
        this.lockQuantity = lockQuantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getGmtCreateTime() {
        return gmtCreateTime;
    }

    public void setGmtCreateTime(Date gmtCreateTime) {
        this.gmtCreateTime = gmtCreateTime;
    }

    public Date getGmtUpdateTime() {
        return gmtUpdateTime;
    }

    public void setGmtUpdateTime(Date gmtUpdateTime) {
        this.gmtUpdateTime = gmtUpdateTime;
    }

    @Override
    public String toString() {
        return "StockDo{" +
                "id=" + id +
                ", skuId=" + skuId +
                ", name='" + name + '\'' +
                ", salesQuantity=" + salesQuantity +
                ", saledQuantity=" + saledQuantity +
                ", lockQuantity=" + lockQuantity +
                ", status=" + status +
                ", gmtCreateTime=" + gmtCreateTime +
                ", gmtUpdateTime=" + gmtUpdateTime +
                '}';
    }
}
