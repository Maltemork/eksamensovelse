package edu.eksamensopgave.eksamensopgave.productOrder;

import edu.eksamensopgave.eksamensopgave.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
    Set<ProductOrder> findAllByProduct(Product product);
}
