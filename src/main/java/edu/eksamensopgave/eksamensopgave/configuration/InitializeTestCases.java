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
        productRepository.save(new Product("Øl", 5, 330));

        // Create product orders
        productOrderRepository.save(new ProductOrder(productRepository.findByProductNameIgnoreCase("Æbler"), 10));
        productOrderRepository.save(new ProductOrder(productRepository.findByProductNameIgnoreCase("Pærer"), 20));
        productOrderRepository.save(new ProductOrder(productRepository.findByProductNameIgnoreCase("Øl"), 120));

        // Create deliveries
        deliveryRepository.save(new Delivery("2021-05-12", "warehouse1", "MinKøbmand Godthåbsvej"));
        deliveryRepository.save(new Delivery("2021-05-13", "warehouse2", "MinKøbmand Nørrebro"));
        deliveryRepository.save(new Delivery("2021-05-14", "warehouse3", "MinKøbmand Frederiksberg"));

        //Add product orders to deliveries
        Delivery delivery1 = deliveryRepository.findById(1).get();
        delivery1.addProductOrder(productOrderRepository.findById(1).get());
        delivery1.addProductOrder(productOrderRepository.findById(2).get());
        deliveryRepository.save(delivery1);

        Delivery delivery2 = deliveryRepository.findById(2).get();
        delivery2.addProductOrder(productOrderRepository.findById(3).get());
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
