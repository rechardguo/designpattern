package rechard.learn.designpattern.strategy;

import java.util.List;
import java.util.stream.Collectors;

@StrategyAnnotation(scope="['hvt']")
public class ConcreteBeneStrategyCanDoHvt extends BeneStrategy {
	@Override
	public List<Bene> filter(List<Bene> benes) {
		return benes.stream().filter(bene -> bene.isCanDoHVT()).collect(Collectors.toList());
	}
}
