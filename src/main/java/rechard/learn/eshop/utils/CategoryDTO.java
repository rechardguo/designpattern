package rechard.learn.eshop.utils;

import java.util.List;

public class CategoryDTO extends AbstractObject {
    private int id;
    private String code;
    private String url;
    private List<CategoryDTO> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<CategoryDTO> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryDTO> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", url='" + url + '\'' +
                ", children=" + children +
                '}';
    }
}
