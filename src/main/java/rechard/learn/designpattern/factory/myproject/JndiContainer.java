package rechard.learn.designpattern.factory.myproject;

/**
 * @author Rechard
 **/
public class JndiContainer {
  public static ServiceC get(){
      return new ServiceC();
  }

}
