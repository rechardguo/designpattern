package rechard.learn.designpattern.factory.myproject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Rechard
 **/
public class ObjectFactoryImpl implements ObjectFactory{
    private volatile Properties config=null;
    private Object lock=new Object();
    private ConcurrentHashMap<String,Producer> cache=new ConcurrentHashMap<>();

   /* public static void main(String[] args) {
        InputStream is = ObjectFactoryImpl.class.getResourceAsStream("/config.properties");
        System.out.println(is==null);
    }*/

    public void init() throws IOException {
        if(config==null) {
            synchronized (lock) {
                if(config==null) {
                    config = new Properties();
                    InputStream is = ObjectFactoryImpl.class.getResourceAsStream("/config.properties");
                    config.load(is);
                }
            }
        }
    }

    protected Producer createProducer(String beanName) throws Exception {
        String producerKey=beanName+".producer";
        if(cache.get(producerKey)!=null)
            return cache.get(beanName);

        String producerClass=(String) this.config.get(producerKey);
        if(producerClass!=null){
            Object object=Class.forName(producerClass).newInstance();
            if(!(object instanceof Producer)){
                throw new Exception("producer must be sub instance of Producer.class");
            }
            cache.put(beanName,(Producer)object);
            return (Producer)object;
        }
        return null;
    }

    @Override
    public Object cretate(String beanName) throws Exception {
        init();
        Producer p=createProducer(beanName);
        //read beanName all config
        HashMap params=retriveAllParameters(beanName);
        return p.produce(params);
    }

    /**
     * 根据beanName来找到所有的配置
     * @param beaName
     * @param params
     */
    private HashMap retriveAllParameters(String beaName){
        HashMap params=new HashMap();
        Enumeration keys=this.config.keys();
        while (keys.hasMoreElements()){
            String key=(String)keys.nextElement();
            if(key.startsWith(beaName+".params.")){
                params.put(key.replaceAll(beaName+".params.",""),this.config.get(key));
            }
        }
        return params;
    }


}
