package rechard.learn.designpattern.strategy;

import java.util.List;

public abstract class BeneStrategy {
	public abstract List<Bene>  filter(List<Bene> benes);
}
