package demo.com.grocery_management_system.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class cart {

    @Id
    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    // Many-to-One relationship with user
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") // Foreign key column to reference the user
    private user user;

    // Getters and Setters
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    // toString Method
    @Override
    public String toString() {
        return "cart [cartId=" + cartId + ", creationDate=" + creationDate + ", user=" + user + "]";
    }

    // Constructors
    public cart(int cartId, LocalDate creationDate, user user) {
        this.cartId = cartId;
        this.creationDate = creationDate;
        this.user = user;
    }

    public cart() {
        super();
    }
}
