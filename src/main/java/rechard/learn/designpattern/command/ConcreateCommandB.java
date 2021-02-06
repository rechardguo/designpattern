package rechard.learn.designpattern.command;

public class ConcreateCommandB implements Command {
    @Override
    public void execute() {
        System.out.println("commandB execute");
    }
}
