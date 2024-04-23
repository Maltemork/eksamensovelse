package edu.eksamensopgave.eksamensopgave.product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    List<Product> findAllByProductNameIgnoreCase(String name);
    Product findByProductNameIgnoreCase(String name);
    Product findByProductId(int id);
}