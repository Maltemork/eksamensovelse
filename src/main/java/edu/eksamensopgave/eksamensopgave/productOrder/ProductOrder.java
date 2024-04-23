package edu.eksamensopgave.eksamensopgave.productOrder;

import edu.eksamensopgave.eksamensopgave.delivery.Delivery;
import edu.eksamensopgave.eksamensopgave.product.Product;
import jakarta.persistence.*;


@Entity
@Table(name = "productOrders")
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne
    private Product product;

    public ProductOrder(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public ProductOrder(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductOrder() {
    }

    // ------- Getters and Setters -------


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public int getProductOrderId() {
        return orderId;
    }
}
