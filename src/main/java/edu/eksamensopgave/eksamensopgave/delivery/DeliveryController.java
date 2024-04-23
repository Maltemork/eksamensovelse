package edu.eksamensopgave.eksamensopgave.delivery;

import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public Delivery addDelivery(@RequestBody DeliveryDTO deliveryDTO) {
        return deliveryService.addDelivery(deliveryDTO);
    }

    @PutMapping("/{id}")
    public Set<ProductOrder> addProductOrdersToDelivery(int id, Set<ProductOrder> productOrders) {
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
