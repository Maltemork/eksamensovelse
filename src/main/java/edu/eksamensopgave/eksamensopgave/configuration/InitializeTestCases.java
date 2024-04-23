package edu.eksamensopgave.eksamensopgave.configuration;

import edu.eksamensopgave.eksamensopgave.delivery.Delivery;
import edu.eksamensopgave.eksamensopgave.delivery.DeliveryRepository;
import edu.eksamensopgave.eksamensopgave.product.Product;
import edu.eksamensopgave.eksamensopgave.product.ProductRepository;
import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrder;
import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrderRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class InitializeTestCases implements ApplicationRunner {
    private ProductRepository productRepository;
    private DeliveryRepository deliveryRepository;
    private ProductOrderRepository productOrderRepository;


    private void createTestCases() {
            // Create and save Products
        Product product1 = new Product("Product1", new BigDecimal(10), 100);
        Product product2 = new Product("Product2", new BigDecimal(20), 200);
        productRepository.save(product1);
        productRepository.save(product2);

            // Create and save ProductOrders
        ProductOrder productOrder1 = new ProductOrder(product1, 10);
        ProductOrder productOrder2 = new ProductOrder(product2, 20);
        productOrderRepository.save(productOrder1);
        productOrderRepository.save(productOrder2);

            // Create and save Deliveries
        Delivery delivery1 = new Delivery("2021-05-12", "warehouse1", "MinKøbmand Godthåbsvej");
        Delivery delivery2 = new Delivery("2021-05-13", "warehouse2", "MinKøbmand Nørrebro");
        deliveryRepository.save(delivery1);
        deliveryRepository.save(delivery2);

            // Add ProductOrders to Deliveries
        delivery1.addProductOrder(productOrder1);
        delivery1.addProductOrder(productOrder2);
        deliveryRepository.save(delivery1);

        delivery2.addProductOrder(productOrder2);
        deliveryRepository.save(delivery2);
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
