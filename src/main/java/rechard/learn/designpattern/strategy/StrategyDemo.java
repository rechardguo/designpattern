package rechard.learn.designpattern.strategy;

import java.lang.annotation.Annotation;
import java.util.List;

public class StrategyDemo {

	public static void main(String[] args) {
		BeneContext context=new BeneContext(new ConcreteBeneStrategyCanDoHvt());

		Bene b1=new Bene("rechard");
		b1.setCanDoAct(true);
		Bene b2=new Bene("james");
		b2.setCanDoHVT(true);
		Bene b3=new Bene("tom");
		b3.setCanDoHVT(true);

		context.addBene(b1);
		context.addBene(b2);
		context.addBene(b3);

		List<Bene> benes=context.filter();
		for (Bene b:benes){
			System.out.println(b.getName());
		}
	}

}
