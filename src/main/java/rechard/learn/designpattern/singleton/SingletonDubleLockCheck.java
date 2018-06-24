package rechard.learn.designpattern.singleton;

public class SingletonDubleLockCheck {

	//private static SingletonDubleLockCheck instance ;
	
	//!!!这里的volatile很重要
	private static volatile SingletonDubleLockCheck instance ;
	
	private SingletonDubleLockCheck(){}
	
	//双锁，必须将instance声明为volatile,因为现在的源码->编译->执行会进行重排序
	//new SingletonDubleLockCheck()的伪代码是
	//1.memory = allocate()
	//2.instance(memory)
	//3.instacne=memory
	//遇到重排序后的结果可能是
	//1.memory = allocate()
	//3.instacne=memory
	//2.instance(memory)
	//加volatile是避免代码重排序
	public static SingletonDubleLockCheck getInstance(){
		if(instance==null){
			synchronized(SingletonDubleLockCheck.class){
				if(instance==null){
					instance = new SingletonDubleLockCheck();
				}
			}
		}
		return instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
