package demo.com.grocery_management_system.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class review {

    @Id
    @Column(name = "review_id")
    private int reviewId;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment", length = 255)
    private String comment;

    @Column(name = "review_date")
    private LocalDate reviewDate;

    // Many-to-One relationship with user
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") // Foreign key to user
    private user user;

    // Many-to-One relationship with product
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id") // Foreign key to product
    private product product;

    // Getters and Setters
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public product getProduct() {
        return product;
    }

    public void setProduct(product product) {
        this.product = product;
    }

    // toString Method
    @Override
    public String toString() {
        return "review [reviewId=" + reviewId + ", rating=" + rating + ", comment=" + comment + ", reviewDate=" 
               + reviewDate + ", user=" + user + ", product=" + product + "]";
    }

    // Constructors
    public review(int reviewId, int rating, String comment, product newProduct, user newUser) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
        this.product = newProduct;
        this.user = newUser;
    }

    public review() {
        super();
    }
}
