package ua.ali_x.Model;

public class Product {

    private Long id;
    private String name;
    private String decription;

    public Product(Long id, String name, String decription) {
        this.id = id;
        this.name = name;
        this.decription = decription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }
}
