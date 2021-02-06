package rechard.learn.designpattern.state;

public class Payment {
    private int state; //0=pending approved,1=partitial apprved,3=approved,4=sent,5=received,6=completed,7=rejected,8=fail
    private String reference;

    public Payment(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
