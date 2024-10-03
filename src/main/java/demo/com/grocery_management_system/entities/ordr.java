package demo.com.grocery_management_system.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ordr {
    
    @Id
    @Column(name = "ordr_id")
    private int ordrId;

    @Column(name = "ordr_date")
    private LocalDate ordrDate;

    @Column(name = "total_amount", precision = 10, scale = 2)
    private double totalAmount;

    @Column(name = "shipping_address", length = 100)
    private String shippingAddress;

    @Column(name = "ordr_status", length = 15)
    private String ordrStatus;

    // Many-to-One relationship with user
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") // Foreign key column
    private user user;

    // Getters and Setters
    public int getOrdrId() {
        return ordrId;
    }

    public void setOrdrId(int ordrId) {
        this.ordrId = ordrId;
    }

    public LocalDate getOrdrDate() {
        return ordrDate;
    }

    public void setOrdrDate(LocalDate ordrDate) {
        this.ordrDate = ordrDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getOrdrStatus() {
        return ordrStatus;
    }

    public void setOrdrStatus(String ordrStatus) {
        this.ordrStatus = ordrStatus;
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
        return "ordr [ordrId=" + ordrId + ", ordrDate=" + ordrDate + ", totalAmount=" + totalAmount
                + ", shippingAddress=" + shippingAddress + ", ordrStatus=" + ordrStatus + ", user=" + user + "]";
    }

    // Constructors
    public ordr(int ordrId, LocalDate ordrDate, double totalAmount, String shippingAddress, String ordrStatus, user user) {
        this.ordrId = ordrId;
        this.ordrDate = ordrDate;
        this.totalAmount = totalAmount;
        this.shippingAddress = shippingAddress;
        this.ordrStatus = ordrStatus;
        this.user = user;
    }

    public ordr() {
        super();
    }
}
