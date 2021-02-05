package rechard.learn.designpattern.facade;

import sun.security.pkcs11.Secmod;

public class WithoutFacadeDemo {

    public static void main(String[] args) {
        ModuleA moduleA=new ModuleA();
        ModuleB moduleB=new ModuleB();
        ModuleC moduleC=new ModuleC();

        moduleA.execute();
        moduleB.execute();
        moduleC.execute();
    }

    public static class ModuleA{
        public void execute(){
            System.out.println("系统模块A");
        }
    }

    public static class ModuleB{
        public void execute(){
            System.out.println("系统模块B");
        }
    }


    public static class ModuleC{
        public void execute(){
            System.out.println("系统模块C");
        }
    }
}

