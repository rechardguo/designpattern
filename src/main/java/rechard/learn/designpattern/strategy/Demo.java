package rechard.learn.designpattern.strategy;

import org.junit.Assert;
import org.junit.Test;

/**
 * 演示的策略 模式
 * @author Rechard
 *
 */
public class Demo {
	
	@Test
	public void test(){
		Bene bene = new Bene();
		bene.canDoAct = true;
		BeneContext pc1= new BeneContext("act",bene);
		boolean result = false;
		try {
			result = BeneStrategyFactory.getInstance().doFilter(pc1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(result);
	}
	
}
