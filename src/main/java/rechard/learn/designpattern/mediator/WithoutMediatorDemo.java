package rechard.learn.designpattern.mediator;

/**
 * 不是用中介着设计模式，每个模块里依赖其他的模块，形成蜘蛛网的依赖
 */
public class WithoutMediatorDemo {

    public static class ModuleA{
        public void execute(){
            System.out.println("ModuleA execute:");
            new ModuleB().execute("moudleA");
            new ModuleC().execute("moudleA");
        }

        public void execute(String invoker){
            System.out.println(invoker+"调用了ModuleA");
        }
    }

    public static class ModuleB{
        public void execute(){
            System.out.println("ModuleB execute:");
            new ModuleA().execute("moudleB");
            new ModuleC().execute("moudleB");
        }
        public void execute(String invoker){
            System.out.println(invoker+"调用了ModuleB");
        }
    }


    public static class ModuleC{
        public void execute(){
            System.out.println("ModuleC execute:");
            new ModuleA().execute("moudleC");
            new ModuleB().execute("moudleC");
        }

        public void execute(String invoker){
            System.out.println(invoker+"调用了ModuleC");
        }
    }
    public static void main(String[] args) {
        new ModuleA().execute();
        new ModuleB().execute();
        new ModuleB().execute();
    }
}
