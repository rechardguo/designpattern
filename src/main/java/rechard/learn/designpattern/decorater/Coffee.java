package rechard.learn.designpattern.decorater;

public class Coffee implements Drink {

	public int cost() {
		return 100;
	}

	public String description() {
		return "coffee";
	}

}
