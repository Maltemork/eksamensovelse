package edu.eksamensopgave.eksamensopgave.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrder;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int productId;

    private int price;

    private String productName;

    private double weight;

    public Product(int price, String productName, double weight) {
        this.price = price;
        this.productName = productName;
        this.weight = weight;
    }

    public Product() {

    }
}
