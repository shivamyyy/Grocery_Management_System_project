package demo.com.grocery_management_system.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class orderitem {

    @Id
    @Column(name = "order_item_id")
    private int orderItemId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_price", precision = 10, scale = 2)
    private double unitPrice;

    // Many-to-One relationship with order
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ordr_id") // Foreign key to order
    private ordr ordr;

    // Many-to-One relationship with product
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id") // Foreign key to product
    private product product;

    // Getters and Setters
    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public ordr getOrder() {
        return ordr;
    }

    public void setOrder(ordr ordr) {
        this.ordr = ordr;
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
        return "orderitem [orderItemId=" + orderItemId + ", quantity=" + quantity + ", unitPrice=" + unitPrice
                + ", order=" + ordr + ", product=" + product + "]";
    }

    // Constructors
    public orderitem(int orderItemId, int quantity, double unitPrice, ordr order, product product) {
        this.orderItemId = orderItemId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.ordr = order;
        this.product = product;
    }

    public orderitem() {
        super();
    }
}
