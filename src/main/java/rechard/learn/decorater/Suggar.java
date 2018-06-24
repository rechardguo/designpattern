package rechard.learn.decorater;

public class Suggar extends CondimentDecorator{

	public Suggar(Drink drink) {
		super(drink);
	}
	
	public int cost() {
		return super.cost()+10;
	}

	public String description() {
		return super.description()+" add Suggar";
	}

}
