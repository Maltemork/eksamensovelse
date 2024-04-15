package edu.eksamensopgave.eksamensopgave.delivery;

import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrder;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Delivery getDelivery(@PathVariable int id) {
        return deliveryService.getDelivery(id);
    }

    @GetMapping
    public List<DeliveryDTO> getDeliveries() {
        return deliveryService.getDeliveries();
    }
}
