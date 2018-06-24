package rechard.learn.designpattern.decorater;

public class Milk extends CondimentDecorator{

	public Milk(Drink drink) {
		super(drink);
	}
	
	public int cost() {
		return super.cost()+20;
	}

	public String description() {
		return super.description()+" add milk";
	}

}
