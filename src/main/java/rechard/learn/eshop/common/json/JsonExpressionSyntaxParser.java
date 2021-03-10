package rechard.learn.eshop.common.json;

/**
 * @author Rechard
 **/
public class JsonExpressionSyntaxParser {

    private final static String SEPERATOR="\\.";

    /**
     * 将表达式解析成一棵抽象语法树
     * @param expr 表达式
     * @return 抽象语法树的根结点
     */
    public static JsonExpression parse(String expr) throws Exception {
        String[] expressions = expr.split(SEPERATOR);
        JsonExpression root=null;
        JsonExpression current=null;
        for(int i=0;i<expressions.length;i++){
            String expression=expressions[i];
            boolean isArray=false;
            if(expression.indexOf("[")!=-1)
                isArray=true;
            if(i==0){
                //头结点不允许有[]
                if(isArray)
                    throw new Exception("头节点不允许是数组");
                if(expressions.length==1){
                    root=new LeafJsonObjectExpression(expression);
                }else{
                    root=new CompositeJsonExpression(expression);
                    current=root;
                }
            }else{
                JsonExpression next=null;
                if(i==expressions.length-1){
                    if(isArray) {
                        next = new LeafJsonArrayExpression(expression);
                    }else {
                        next = new LeafJsonObjectExpression(expression);
                    }
                }else{
                    if(isArray) {
                        next = new JsonArrayExpression(expression);
                    }else{
                        next = new CompositeJsonExpression(expression);
                    }
                }
                ((AbstractCompositeJsonExpression)current).setNext(next);
                current=next;
            }
        }
        return root;
    }

}
