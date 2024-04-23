package edu.eksamensopgave.eksamensopgave.productOrder;

import edu.eksamensopgave.eksamensopgave.product.Product;
import edu.eksamensopgave.eksamensopgave.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductOrderService {

    private final ProductOrderRepository productOrderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ProductOrderService(ProductOrderRepository productOrderRepository, ProductRepository productRepository) {
        this.productOrderRepository = productOrderRepository;
        this.productRepository = productRepository;
    }

    // Add your methods here
    public ProductOrder addProductOrder(ProductOrderDTO productOrderDTO) {
        Product product = productRepository.findById(productOrderDTO.getProduct().getProductId()).orElse(null);

        if (product == null) {
            throw new IllegalArgumentException("Product with id " + productOrderDTO.getProduct().getProductId() + " does not exist");
        }

        ProductOrder productOrder = new ProductOrder(productOrderDTO.getQuantity(), product);
        productOrderRepository.save(productOrder);
        return productOrder;
    }

    public List<ProductOrderDTO> getAllProductOrders() {
        return productOrderRepository.findAll().stream()
                .map(productOrder -> new ProductOrderDTO(productOrder.getProductOrderId(), productOrder.getQuantity(), productOrder.getProduct()))
                .collect(Collectors.toList());
    }
}