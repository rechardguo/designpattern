package rechard.learn.designpattern.command;

public class ConcreateCommandA implements Command {
    @Override
    public void execute() {
        System.out.println("commandA execute");
    }
}
