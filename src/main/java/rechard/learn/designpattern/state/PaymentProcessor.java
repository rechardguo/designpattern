package rechard.learn.designpattern.state;

public class PaymentProcessor {
    private PaymentProcessor(){}

    public static PaymentProcessor getInstance(){
        return Singleton.holder;
    }

    //如果没找到就抛出异常之类的，演示就不做了
    private PaymentState calPaymentState(Payment payment){
        if(payment.getState()==0){
            return new PaymentPendingState();
        }else if(payment.getState()==7){
            return new PaymentRejectedState();
        }
        return null;
    }

    public  void approve(Payment payment){
        PaymentState state=calPaymentState(payment);
        state.approve(payment);
    }

    public  void reject(Payment payment){
        PaymentState state=calPaymentState(payment);
        state.reject(payment);
    }


    private static class Singleton{
        static PaymentProcessor holder=new PaymentProcessor();
    }

}
