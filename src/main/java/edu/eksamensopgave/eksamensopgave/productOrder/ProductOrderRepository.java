package edu.eksamensopgave.eksamensopgave.productOrder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
}
