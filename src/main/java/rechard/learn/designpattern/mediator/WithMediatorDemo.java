package rechard.learn.designpattern.mediator;

public class WithMediatorDemo {

    public static class Mediator{
        private ModuleA moduleA;
        private ModuleB moduleB;
        private ModuleC moduleC;

        public ModuleA getModuleA() {
            return moduleA;
        }

        public void setModuleA(ModuleA moduleA) {
            this.moduleA = moduleA;
        }

        public ModuleB getModuleB() {
            return moduleB;
        }

        public void setModuleB(ModuleB moduleB) {
            this.moduleB = moduleB;
        }

        public ModuleC getModuleC() {
            return moduleC;
        }

        public void setModuleC(ModuleC moduleC) {
            this.moduleC = moduleC;
        }

        public void aExecute(){
            System.out.println("ModuleA execute:");
            this.moduleB.execute("moudleA");
            this.moduleC.execute("moudleA");
        }

        public void bExecute(){
            System.out.println("ModuleB execute:");
            this.moduleA.execute("moudleB");
            this.moduleC.execute("moudleB");
        }

        public void cExecute(){
            System.out.println("ModuleC execute:");
            this.moduleA.execute("moudleC");
            this.moduleB.execute("moudleC");
        }
    }

    public static class ModuleA{
        private Mediator mediator;

        public ModuleA(Mediator mediator) {
            this.mediator = mediator;
            mediator.setModuleA(this);
        }

        public void execute(){
           this.mediator.aExecute();
        }

        public void execute(String invoker){
            System.out.println(invoker+"调用了ModuleA");
        }
    }

    public static class ModuleB{
        private Mediator mediator;

        public ModuleB(Mediator mediator) {
            this.mediator = mediator;
            mediator.setModuleB(this);
        }

        public void execute(){
            this.mediator.aExecute();
        }
        public void execute(String invoker){
            System.out.println(invoker+"调用了ModuleB");
        }
    }


    public static class ModuleC{
        private Mediator mediator;

        public ModuleC(Mediator mediator) {
            this.mediator = mediator;
            mediator.setModuleC(this);
        }

        public void execute(){
            this.mediator.aExecute();
        }
        public void execute(String invoker){
            System.out.println(invoker+"调用了ModuleC");
        }
    }
    public static void main(String[] args) {
        Mediator mediator=new Mediator();
        ModuleA a=new ModuleA(mediator);
        ModuleB b=new ModuleB(mediator);
        ModuleC c=new ModuleC(mediator);

        a.execute();
        b.execute();
        c.execute();
    }
}
