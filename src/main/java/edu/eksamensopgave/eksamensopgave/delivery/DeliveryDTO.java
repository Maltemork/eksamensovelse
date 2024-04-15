package edu.eksamensopgave.eksamensopgave.delivery;

import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrder;

import java.util.Date;
import java.util.List;

public record DeliveryDTO(int deliveryId, Date deliveryDate, String fromWareHouse, String destination, List<ProductOrder> productOrders) {
    
}
