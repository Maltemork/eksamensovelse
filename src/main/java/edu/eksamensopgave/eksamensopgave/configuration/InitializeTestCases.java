package edu.eksamensopgave.eksamensopgave.configuration;

import edu.eksamensopgave.eksamensopgave.delivery.DeliveryRepository;
import edu.eksamensopgave.eksamensopgave.product.Product;
import edu.eksamensopgave.eksamensopgave.product.ProductRepository;
import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrder;
import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrderRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializeTestCases implements ApplicationRunner {
    private ProductRepository productRepository;
    private DeliveryRepository deliveryRepository;
    private ProductOrderRepository productOrderRepository;


    private void createTestCases() {
        // Create products
        productRepository.save(new Product("Æbler", 19.95, 200));
        productRepository.save(new Product("Pærer", 20, 200.80));
        productRepository.save(new Product("Bananer", 16, 500));

    }
    @Override
    public void run(ApplicationArguments args) {
        createTestCases();
    }

    // Constructor
    public InitializeTestCases(ProductRepository productRepository, DeliveryRepository deliveryRepository, ProductOrderRepository productOrderRepository) {
        this.productRepository = productRepository;
        this.deliveryRepository = deliveryRepository;
        this.productOrderRepository = productOrderRepository;
    }
}
