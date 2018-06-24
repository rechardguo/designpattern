package rechard.learn.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式的java api的实现，观察者模式是推模式
 * 发布订阅模式
 * 简单理解：Observable里有个vector容器来装订阅者
 * 通过Observable的notify来向订阅者推送消息，
 * 即 迭代vector里的实现了Observer的类的update方法
 * @author Rechard
 *
 */
public class Demo {

	public static void main(String[] args) {

		MyObservable observable = new MyObservable();

		//不同的订阅者
		
		//James
		observable.addObserver(new Observer() {
			public void update(Observable o, Object value) {
				if(value.toString().equals("sport")){
					System.out.println("I am james ,i like sport");
				}
			}
		});
		//Allice
		observable.addObserver(new Observer() {
			public void update(Observable o, Object value) {
				if(value.toString().equals("music")){
					System.out.println("I am Allice ,i like music");
				}
			}
		});
		
		observable.setChanged();
		observable.notifyObservers("sport");

	}

	public static class MyObservable extends Observable{
		public synchronized void setChanged() {
			super.setChanged();
		}
	}
}
