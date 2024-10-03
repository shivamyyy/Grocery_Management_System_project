package demo.com.grocery_management_system.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class cartitem {

    @Id
    @Column(name = "cart_item_id")
    private int cartItemId;

    @Column(name = "quantity")
    private int quantity;

    // Many-to-One relationship with cart
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id") // Foreign key to cart
    private cart cart;

    // Many-to-One relationship with product
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id") // Foreign key to product
    private product product;

    // Getters and Setters
    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public cart getCart() {
        return cart;
    }

    public void setCart(cart cart) {
        this.cart = cart;
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
        return "cartitem [cartItemId=" + cartItemId + ", quantity=" + quantity + ", cart=" + cart + ", product=" + product + "]";
    }

    // Constructors
    public cartitem(int cartItemId, int quantity, cart cart, product product) {
        this.cartItemId = cartItemId;
        this.quantity = quantity;
        this.cart = cart;
        this.product = product;
    }

    public cartitem() {
        super();
    }
}
