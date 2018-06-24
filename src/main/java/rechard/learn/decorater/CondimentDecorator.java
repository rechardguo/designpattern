package rechard.learn.decorater;

public class CondimentDecorator implements Drink{

	private Drink drink;
	public CondimentDecorator(Drink drink){
		this.drink = drink;
	}
	
	public int cost() {
		return drink.cost();
	}

	public String description() {
		return drink.description();
	}

}
