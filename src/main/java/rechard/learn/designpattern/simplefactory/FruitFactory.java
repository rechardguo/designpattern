package rechard.learn.designpattern.simplefactory;

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
