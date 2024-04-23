package edu.eksamensopgave.eksamensopgave.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "products")
public class Product {
    // --------Fields--------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int productId;

    // Price is rounded down to 2 decimals.
    private BigDecimal price;

    @Column(unique = true)
    private String productName;

    //Weight in grams.
    private double weight;

    // -------Constructors--------
    public Product() {

    }

    // Main constructor.
    public Product(String productName, BigDecimal price, double weight) {
        this.price = price;
        this.productName = productName;
        this.weight = weight;
    }

    // Constructors for creating a product when doubles/int's are received instead of BigDecimals.
    // This is simply for ease of use, and allowing the frontend and test-cases to create the products,
    // even if they don't have decimal-points or are BigDecimals.
    public Product(String productName, double price, double weight) {
        this(productName, new BigDecimal(price).setScale(2, RoundingMode.HALF_UP), weight);
    }

    public Product(String productName, int price, double weight) {
        this(productName, new BigDecimal(price).setScale(2, RoundingMode.HALF_UP), weight);
    }

    public Product(String productName, double price, int weight) {
        this(productName, new BigDecimal(price).setScale(2, RoundingMode.HALF_UP), weight);
    }

    public Product(String productName, int price, int weight) {
        this(productName, new BigDecimal(price).setScale(2, RoundingMode.HALF_UP), weight);
    }

    // -------Getters and setters--------
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price.setScale(2, RoundingMode.HALF_UP);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getProductId() {
        return productId;
    }

    public String toString() {
        return
                "productId = " + productId +
                ", price = " + price +
                ", productName = '" + productName + '\'' +
                ", weight = " + weight +
                '}';
    }
}