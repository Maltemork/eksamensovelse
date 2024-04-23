package edu.eksamensopgave.eksamensopgave.delivery;

import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrder;

import java.util.Date;
import java.util.List;

public record DeliveryDTO(Integer deliveryId, Date deliveryDate, String fromWarehouse, String destination, List<ProductOrder> productOrders) {
    
}
