package rechard.learn.designpattern.singleton;

/**
 * 第2种写法
 * JVM在类的初始化阶段（即在Class被加载后，且被线程使用之前），会执行类的初始化。
 * 在 执行类的初始化期间，JVM会去获取一个锁。这个锁可以同步多个线程对同一个类的初始化。
 * @author Rechard
 *
 */
public class Singleton2 {

	
	static class Singleton2Holder{
		public static Singleton2 instance = new Singleton2();
	}
	/**
	 * 这里将导致Singleton2Holder类被初始化 
	 * @return
	 */
	public static Singleton2 getInsance(){
		return Singleton2Holder.instance;
	}
	
}
