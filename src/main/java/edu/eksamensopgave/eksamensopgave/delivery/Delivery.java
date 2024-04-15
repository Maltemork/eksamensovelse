package edu.eksamensopgave.eksamensopgave.delivery;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "deliveries")
public class Delivery {
    @Id
    private int deliveryId;
    private Date deliveryDate;
    private boolean fromWareHouse;
    private String destination;

    public Delivery(Date deliveryDate, boolean fromWareHouse, String destination) {
        this.deliveryDate = deliveryDate;
        this.fromWareHouse = fromWareHouse;
        this.destination = destination;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public boolean isFromWareHouse() {
        return fromWareHouse;
    }

    public void setFromWareHouse(boolean fromWareHouse) {
        this.fromWareHouse = fromWareHouse;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
