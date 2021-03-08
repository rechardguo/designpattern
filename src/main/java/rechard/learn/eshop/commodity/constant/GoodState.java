package rechard.learn.eshop.commodity.constant;

/**
 * @author Rechard
 **/
public enum GoodState {
    Created(0),
    Pending_Approval(1),Approved(2),
    Pending_PutOnShelf_approval(3),
    PutOnShelf(4),Removed(5),Rejected(6),
    PutOnShelf_Rejected(7),PutOffShelf(8);

    private int code;

    GoodState(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

    public static GoodState valueOf(int code){
        GoodState[] states=GoodState.values();
        for(GoodState st:states){
            if(st.code==code)
                return st;
        }
        return null;
    }


}
