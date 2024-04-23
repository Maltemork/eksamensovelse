package edu.eksamensopgave.eksamensopgave.delivery;

import edu.eksamensopgave.eksamensopgave.product.Product;
import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{
    // Find delivery by ID.
    Delivery findByDeliveryId(int id);
}
