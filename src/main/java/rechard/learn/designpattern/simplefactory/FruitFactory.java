package rechard.learn.designpattern.simplefactory;

import rechard.learn.designpattern.factory.Apple;
import rechard.learn.designpattern.factory.Bananer;
import rechard.learn.designpattern.factory.Fruit;
import rechard.learn.designpattern.factory.Orange;

public class FruitFactory {

	public Fruit getFruit(String name){
		if(name.equals("Apple")){
			return new Apple();
		}else if(name.equals("Orange")){
			return new Orange();
		}else if(name.equals("Bananer")){
			return new Bananer();
		}else{
			return null;
		}
	}
}
