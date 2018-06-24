package rechard.learn.designpattern.strategy;
@StrategyAnnotation(scope="['hvt']")
public class ConcreteBeneStrategy2  extends BeneStrategy {
	@Override
	public boolean filter(BeneContext context) {
		return context.bene.canDoHVT ;
	}
}
