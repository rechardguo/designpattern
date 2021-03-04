package rechard.learn.eshop.auth.domain;

import rechard.learn.eshop.utils.AbstractObject;

public class PriorityDO extends AbstractObject {

    private int id;
    private int pid;
    private String url;
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
