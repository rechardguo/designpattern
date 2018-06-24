package rechard.learn.designpattern.strategy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME )  
public @interface StrategyAnnotation {
	public String[] scope();
}
