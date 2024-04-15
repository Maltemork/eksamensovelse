package edu.eksamensopgave.eksamensopgave.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrder;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "deliveries")
public class Delivery {
    // ------- Fields -------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int deliveryId;
    private Date deliveryDate;
    private String fromWareHouse;
    private String destination;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductOrder> productOrders;

    // ------- Constructors -------
    public Delivery() {

    }
    public Delivery(Date deliveryDate, String fromWareHouse, String destination) {
        this.deliveryDate = deliveryDate;
        this.fromWareHouse = fromWareHouse;
        this.destination = destination;
    }

    public Delivery(int deliveryId, Date deliveryDate, String destination, String fromWareHouse) {
    }


    // ------- Getters and Setters -------
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getFromWareHouse() {
        return fromWareHouse;
    }

    public void setFromWareHouse(String fromWareHouse) {
        this.fromWareHouse = fromWareHouse;
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


}
