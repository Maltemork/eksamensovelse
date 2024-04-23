package edu.eksamensopgave.eksamensopgave.delivery;

import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrder;
import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "deliveries")
public class Delivery {
    // ------- Fields -------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int deliveryId;
    private Date deliveryDate;
    @Column(name = "from_warehouse")
    private String fromWarehouse;
    private String destination;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductOrder> productOrders = new HashSet<>();

    // ------- Constructors -------
    public Delivery() {

    }
    public Delivery(Date deliveryDate, String fromWarehouse, String destination) {
        this.deliveryDate = deliveryDate;
        this.fromWarehouse = fromWarehouse;
        this.destination = destination;
    }

    public Delivery(int deliveryId, Date deliveryDate, String destination, String fromWarehouse) {
        this.deliveryId = deliveryId;
        this.deliveryDate = deliveryDate;
        this.destination = destination;
        this.fromWarehouse = fromWarehouse;
    }

    public Delivery(String deliveryDateString, String fromWarehouse, String destination) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.deliveryDate = formatter.parse(deliveryDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.fromWarehouse = fromWarehouse;
        this.destination = destination;
    }


    // ------- Getters and Setters -------
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getFromWarehouse() {
        return fromWarehouse;
    }

    public void setFromWarehouse(String fromWarehouse) {
        this.fromWarehouse = fromWarehouse;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDeliveryId() {
        return deliveryId;
    }


    public void setProductOrders(Set<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }

    public void addProductOrder(ProductOrder productOrder) {
        productOrders.add(productOrder);
    }

    public Set<ProductOrder> getProductOrders() {
        return productOrders;
    }
}
