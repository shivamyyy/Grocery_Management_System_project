package demo.com.grocery_management_system.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class product {

    @Id
    @Column(name = "product_id")
    private int productId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "price", precision = 10, scale = 2)
    private double price;

    @Column(name = "stock")
    private int stock;

    // Many-to-One relationship with category
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id") // Foreign key to category
    private category category;

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public category getCategory() {
        return category;
    }

    public void setCategory(category category) {
        this.category = category;
    }

    // toString Method
    @Override
    public String toString() {
        return "product [productId=" + productId + ", name=" + name + ", description=" + description 
                + ", price=" + price + ", stock=" + stock + ", category=" + category + "]";
    }

    // Constructors
    public product(int productId, String name, String description, double price, int stock, category category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public product() {
        super();
    }
}
