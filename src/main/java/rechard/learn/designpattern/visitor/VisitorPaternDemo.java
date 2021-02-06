package rechard.learn.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorPaternDemo {

    public static void main(String[] args) {
        Component root=new Component("root");
        root.setActive(true);
        Component child1=new Component("root_ch1");
        child1.setActive(true);
        Component child2= new Component("root_ch2");
        child2.setActive(true);
        List<Component> children =new ArrayList<>();
        children.add(child1);
        children.add(child2);
        root.setChildren(children);
        root.accept(new ActiveVisitor());
        root.accept(new LeafVisitor());
    }


    public static interface Visitor{
        public void visit(Component component);
    }

    //叶子结点visitor
    public static class LeafVisitor implements Visitor{
        public void visit(Component component) {
            if (component.isActive() && component.getChildren()==null) {
                System.out.println(component.getName());
            }
        }
    }

    public static class ActiveVisitor implements Visitor{
        public void visit(Component component) {
            if (component.isActive()) {
                System.out.println(component.getName());
            }
        }
    }

    public static class Component{
        private List<Component> children;
        private String name;
        private boolean active;

        public void accept(Visitor visitor){
            visitor.visit(this);
            if (children != null) {
                for (Component c :children) {
                    c.accept(visitor);
                }
            }
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public boolean isActive() {
            return active;
        }
        public void setActive(boolean active) {
            this.active = active;
        }
        public Component(String name) {
            this.name = name;
        }
        public List<Component> getChildren() {
            return children;
        }

        public void setChildren(List<Component> children) {
            this.children = children;
        }
    }

}
