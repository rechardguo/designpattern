package rechard.learn.eshop.auth.domain;

import rechard.learn.eshop.auth.service.PriorityOperation;

import java.util.List;

public class Priority {

    private int id;
    private int pid;
    private String name;
    private String code;
    private List<Priority> children;

    //传入一个 visitor对象，命名叫PriorityOperation
    //由PriorityOperation来处理
    public void operate(PriorityOperation operation){
        operation.execute(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Priority> getChildren() {
        return children;
    }

    public void setChildren(List<Priority> children) {
        this.children = children;
    }
}
