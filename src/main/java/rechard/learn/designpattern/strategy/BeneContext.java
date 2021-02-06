package rechard.learn.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

public class BeneContext {
	public BeneStrategy strategy;
	public List<Bene> allBenes ;

	public BeneContext(BeneStrategy strategy) {
		this.strategy = strategy;
		this.allBenes=new ArrayList<>();
	}

	public void addBene(Bene bene) {
		this.allBenes.add(bene);
	}

	public List<Bene> filter(){
		return this.strategy.filter(this.allBenes);
	}

}
