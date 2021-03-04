package rechard.learn.eshop.auth.domain;

public class AccountPriorityDO {

    private int id;
    //角色id
    private int acctId;
    //权限id
    private int priorityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcctId() {
        return acctId;
    }

    public void setAcctId(int acctId) {
        this.acctId = acctId;
    }

    public int getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
    }
}
