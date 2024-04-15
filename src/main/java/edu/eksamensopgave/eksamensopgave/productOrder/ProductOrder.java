package edu.eksamensopgave.eksamensopgave.productOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productOrders")
public class ProductOrder {
    @Id
    private int orderId;
    private int quantity;

    public ProductOrder(int quantity) {
        this.quantity = quantity;
    }
}
