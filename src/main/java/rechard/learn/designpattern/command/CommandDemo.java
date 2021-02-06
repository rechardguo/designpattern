package rechard.learn.designpattern.command;

public class CommandDemo {
    public static void main(String[] args) {
        Command commandA=new ConcreateCommandA();
        new Invoker(commandA).execute();

        Command commandB=new ConcreateCommandB();
        new Invoker(commandB).execute();
    }
}
