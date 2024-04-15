package edu.eksamensopgave.eksamensopgave.delivery;

import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public List<DeliveryDTO> getDeliveries() {
        return deliveryRepository.findAll().stream()
                .map(delivery -> new DeliveryDTO(delivery.getDeliveryId(), delivery.getDeliveryDate(), delivery.getFromWareHouse(), delivery.getDestination(), delivery.getProductOrders()))
                .collect(Collectors.toList());
    }
    public Delivery getDelivery(int id) {
        return deliveryRepository.findByDeliveryId(id);
    }

    public Delivery addDelivery(DeliveryDTO deliveryDTO) {
        Delivery delivery = new Delivery(deliveryDTO.deliveryDate(), deliveryDTO.fromWareHouse(), deliveryDTO.destination());
        deliveryRepository.save(delivery);
        return delivery;
    }

    public List<ProductOrder> addProductOrdersToDelivery(int id, List<ProductOrder> productOrders) {
        Delivery delivery = deliveryRepository.findById(id).orElse(null);
        if (delivery != null) {
            delivery.setProductOrders(productOrders);
            deliveryRepository.save(delivery);
            return productOrders;
        }
        return null;
    }
}
