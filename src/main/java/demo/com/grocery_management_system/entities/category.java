package demo.com.grocery_management_system.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class category {

    @Id
    @Column(name = "id", length = 10)
    private String categoryId;

    @Column(name = "category_name", length = 15)
    private String categoryName;

    @Column(name = "description", length = 100)
    private String description;

    // Getters and Setters
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // toString Method
    @Override
    public String toString() {
        return "category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description + "]";
    }

    // Constructors
    public category(String categoryId, String categoryName, String description) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
    }

    public category() {
        super();
    }
}
