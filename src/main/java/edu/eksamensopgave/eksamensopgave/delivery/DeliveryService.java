package edu.eksamensopgave.eksamensopgave.delivery;

import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public List<DeliveryDTO> getDeliveries() {
        return deliveryRepository.findAll().stream()
                .map(delivery -> new DeliveryDTO(delivery.getDeliveryId(), delivery.getDeliveryDate(), delivery.getFromWarehouse(), delivery.getDestination(), new ArrayList<>(delivery.getProductOrders())))
                .collect(Collectors.toList());
    }
    public Delivery getDelivery(int id) {
        return deliveryRepository.findByDeliveryId(id);
    }

    public Delivery convertDtoToEntity(DeliveryDTO deliveryDTO) {
        Delivery delivery = new Delivery();
        delivery.setDeliveryDate(deliveryDTO.deliveryDate());
        delivery.setFromWarehouse(deliveryDTO.fromWarehouse());
        delivery.setDestination(deliveryDTO.destination());
        // Check if productOrders is null before passing it to the HashSet constructor
        if (deliveryDTO.productOrders() != null) {
            delivery.setProductOrders(new HashSet<>(deliveryDTO.productOrders()));
        } else {
            delivery.setProductOrders(new HashSet<>());
        }
        return delivery;
    }

    public Delivery addDelivery(DeliveryDTO deliveryDTO) {
        Delivery delivery = convertDtoToEntity(deliveryDTO);
        return deliveryRepository.save(delivery);
    }

    public Set<ProductOrder> addProductOrdersToDelivery(int id, Set<ProductOrder> productOrders) {
        Delivery delivery = deliveryRepository.findById(id).orElse(null);
        if (delivery != null) {
            delivery.setProductOrders(productOrders);
            deliveryRepository.save(delivery);
            return productOrders;
        }
        return null;
    }


}
