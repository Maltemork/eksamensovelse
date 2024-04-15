package edu.eksamensopgave.eksamensopgave.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.eksamensopgave.eksamensopgave.product.Product;
import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrder;
import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "deliveries")
public class Delivery {
    // ------- Fields -------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryId;
    private Date deliveryDate;
    private String fromWareHouse;
    private String destination;

    @OneToMany(fetch = FetchType.EAGER)
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
        this.deliveryId = deliveryId;
        this.deliveryDate = deliveryDate;
        this.destination = destination;
        this.fromWareHouse = fromWareHouse;
    }

    public Delivery(String deliveryDateString, String fromWareHouse, String destination) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.deliveryDate = formatter.parse(deliveryDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.fromWareHouse = fromWareHouse;
        this.destination = destination;
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


    public void setProductOrders(List<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }

    public void addProductOrder(ProductOrder productOrder) {
        productOrders.add(productOrder);
    }

    public List<ProductOrder> getProductOrders() {
        return productOrders;
    }
}
