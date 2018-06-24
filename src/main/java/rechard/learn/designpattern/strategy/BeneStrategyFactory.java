package rechard.learn.designpattern.strategy;

import java.io.File;
import java.io.FileFilter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BeneStrategyFactory {
	
	private final static String STRATEGY_PACKAGE = "rechard.learn.designpattern.strategy"; 
	
	private static List<BeneStrategy> clazzContainer = null;
	
	private BeneStrategyFactory(){}
	public static BeneStrategyFactory getInstance(){
		return Holder.instance;
	}
	private static class Holder{
		public static BeneStrategyFactory instance = new BeneStrategyFactory();
	}
	
	private synchronized void init() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		clazzContainer = new ArrayList<BeneStrategy>();
		ClassLoader cl = this.getClass().getClassLoader();
			File[] files = getResources();
			for(File file : files){
				Class clazz = cl.loadClass(STRATEGY_PACKAGE + "." + file.getName().replace(".class", ""));
				//只有满足了继承了StrategyAnnotation和 StrategyAnnotation annotation才放入list
				if(/*clazz.isAnnotationPresent(StrategyAnnotation.class)*/
						clazz.getAnnotation(StrategyAnnotation.class)!=null &&
								BeneStrategy.class.isAssignableFrom(clazz) && 
						clazz!= BeneStrategy.class){
					clazzContainer.add((BeneStrategy)clazz.newInstance());
					}
			}
	}
	
	//获取扫描的包下面所有的class文件
    private File[] getResources() {
        try {
            File file = new File(getClass().getClassLoader().getResource(STRATEGY_PACKAGE.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    if (pathname.getName().endsWith(".class")) {//我们只扫描class文件
                        return true;
                    }
                    return false;
                }
            });
        } catch (URISyntaxException e) {
            throw new RuntimeException("未找到策略资源");
        }
    }
	
	
	public boolean doFilter(BeneContext pc) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		if(clazzContainer==null){
			init();
		}
		BeneStrategy ps = null;
		Iterator<BeneStrategy> it = clazzContainer.iterator();
		while(it.hasNext()){
			ps = it.next();
			StrategyAnnotation a = ps.getClass().getAnnotation(StrategyAnnotation.class);
			String[] scope = a.scope();
			for(String str : scope){
				if(str.equals(pc.type))
					break;
			}
		}
		
		if(ps!=null)
			return ps.filter(pc);
		return false;
	}
	
	
	
}
