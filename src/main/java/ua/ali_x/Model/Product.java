package ua.ali_x.Model;

public class Product {

    private Integer id;
    private String name;
    private String description;
    private Integer c_id;

    public Product(Integer id, String name, String description, Integer c_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.c_id = c_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String decription) {
        this.description = decription;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }
}
