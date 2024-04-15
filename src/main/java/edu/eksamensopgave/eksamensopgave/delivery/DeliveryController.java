package edu.eksamensopgave.eksamensopgave.delivery;

import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public Delivery addDelivery(DeliveryDTO deliveryDTO) {
        return deliveryService.addDelivery(deliveryDTO);
    }

    @PutMapping("/{id}")
    public List<ProductOrder> addProductOrdersToDelivery(int id, List<ProductOrder> productOrders) {
        return deliveryService.addProductOrdersToDelivery(id, productOrders);
    }
}
