package rechard.learn.designpattern.strategy;

import java.util.List;
import java.util.stream.Collectors;


@StrategyAnnotation(scope="['act']")
public class ConcreteBeneStrategyCanDoAct extends BeneStrategy {
	@Override
	public List<Bene> filter(List<Bene> benes) {
		return benes.stream().filter(bene -> bene.isCanDoAct()).collect(Collectors.toList());
	}
}
