package rechard.learn.designpattern.strategy;

public class BeneContext {
	public String type;
	
	public Bene bene;
	
	public BeneContext(String type,Bene bene){
		this.type = type;
		this.bene = bene;
	}
}
