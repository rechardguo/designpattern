package rechard.learn.designpattern.memento;

public class Originator {


    public static void main(String[] args) {
//        Originator originator=new Originator("abc");
//        originator.executeA();
//        originator.executeB();

        Originator originator=new Originator("abc");
        //取出一份备份数据
        Memoto memoto=originator.createMemento();
        //放到一个看门人（caretaker）
        CareTaker careTaker=new CareTaker();
        //保存一份数据
        careTaker.keep(memoto);
        //执行A方法
        originator.executeA();
        //还原出保存的memo
        originator.retrieve(careTaker.retriveMemoto());
        //继续执行B方法
        originator.executeB();
    }

    public  class Memoto<T>{
        T t;
        public Memoto(T t) {
            this.t = t;
        }

        public T getMemo() {
            return t;
        }

        public void setMemo(T t) {
            this.t = t;
        }
    }

    public static class CareTaker{
        private Memoto memoto;

        public Memoto retriveMemoto() {
            return memoto;
        }

        public void keep(Memoto memoto) {
            this.memoto = memoto;
        }
    }



    private Memoto createMemento() {
        return new Memoto(this.state);
    }

    private void retrieve(Memoto memoto){
        this.state=(String)memoto.getMemo();
    }

    private String state;

    public Originator(String state) {
        this.state = state;
    }

    public void executeA(){
        System.out.println("基于["+state+"],执行A方法");
        state+=",A方法数据";
    }

    public void executeB(){
        System.out.println("基于["+state+"],执行B方法");
        state+=",B方法数据";
    }
}
