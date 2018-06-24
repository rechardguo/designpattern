package rechard.learn.designpattern.strategy;
@StrategyAnnotation(scope="['act']")
public class ConcreteBeneStrategy extends BeneStrategy {

	@Override
	public boolean filter(BeneContext context) {
		
		return context.bene.canDoAct ;
	}

}
