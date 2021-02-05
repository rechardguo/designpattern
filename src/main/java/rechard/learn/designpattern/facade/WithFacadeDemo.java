package rechard.learn.designpattern.facade;

public class WithFacadeDemo {

    public static void main(String[] args) {
        new SystemFacade().execute();
    }

    public static class SystemFacade{
        public void execute(){
            WithoutFacadeDemo.ModuleA moduleA=new WithoutFacadeDemo.ModuleA();
            WithoutFacadeDemo.ModuleB moduleB=new WithoutFacadeDemo.ModuleB();
            WithoutFacadeDemo.ModuleC moduleC=new WithoutFacadeDemo.ModuleC();

            moduleA.execute();
            moduleB.execute();
            moduleC.execute();
        }
    }



}

