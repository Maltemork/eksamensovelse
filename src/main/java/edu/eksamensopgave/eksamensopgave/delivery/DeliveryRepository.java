package edu.eksamensopgave.eksamensopgave.delivery;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{
    // Find delivery by ID.
    Delivery findByDeliveryId(int id);
}
