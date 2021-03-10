package rechard.learn.eshop.common.json;

/**
 * @author Rechard
 **/
public  abstract  class AbstractCompositeJsonExpression implements JsonExpression{
    protected String expression;
    protected JsonExpression next=null;
    public AbstractCompositeJsonExpression( String expression) {
        this.expression = expression;
    }
    public JsonExpression getNext() {
        return next;
    }
    public void setNext(JsonExpression next) {
        this.next = next;
    }
}
