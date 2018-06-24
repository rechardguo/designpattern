package rechard.learn.designpattern.strategy;

import java.lang.annotation.Annotation;

public class StrategyDemo {

	public static void main(String[] args) {

		ConcreteBeneStrategy s = new ConcreteBeneStrategy();
		s.getClass().getGenericSuperclass();
		System.out.println(s.getClass().isAssignableFrom(BeneStrategy.class));
		System.out.println(s.getClass().getAnnotation(StrategyAnnotation.class));
		Annotation[] annotations = s.getClass().getAnnotations();
		for (int i = 0; i < annotations.length; i++) {
			System.out.println(annotations[i]);
		}
		
	}

}
