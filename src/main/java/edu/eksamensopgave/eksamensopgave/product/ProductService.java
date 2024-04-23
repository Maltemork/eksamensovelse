package edu.eksamensopgave.eksamensopgave.product;
import edu.eksamensopgave.eksamensopgave.delivery.Delivery;
import edu.eksamensopgave.eksamensopgave.delivery.DeliveryRepository;
import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrder;
import edu.eksamensopgave.eksamensopgave.productOrder.ProductOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductOrderRepository productOrderRepository;
    private final DeliveryRepository deliveryRepository;

    public ProductService(ProductRepository productRepository, ProductOrderRepository productOrderRepository, DeliveryRepository deliveryRepository) {
        this.productRepository = productRepository;
        this.productOrderRepository = productOrderRepository;
        this.deliveryRepository = deliveryRepository;
    }

    public List<ProductDTO> getProducts() {
        return productRepository.findAll().stream()
                .map(product -> new ProductDTO(product.getProductId(), product.getProductName(), product.getPrice(),  product.getWeight()))
                .collect(Collectors.toList());
    }

    public Product getProduct(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO.productName(), productDTO.price(), productDTO.weight());
        productRepository.save(product);
        return product;
    }

    public List<ProductDTO> getProductsByName(String productName) {
        List<Product> foundProducts = productRepository.findAllByProductNameIgnoreCase(productName);
        return foundProducts.stream()
                .map(product -> new ProductDTO(product.getProductId(), product.getProductName(), product.getPrice(), product.getWeight()))
                .collect(Collectors.toList());
    }

    public void deleteProduct(int id) {
        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            throw new IllegalArgumentException("Product with id " + id + " does not exist");
        }

        // Check if there are any ProductOrders that reference the Product
        Set<ProductOrder> productOrders = productOrderRepository.findAllByProduct(product);
        if (productOrders != null) {
            for (ProductOrder productOrder : productOrders) {
                productOrder.setProduct(null);
                productOrderRepository.save(productOrder);
            }
        }

        productRepository.delete(product);
    }

    public Product updateProduct(int id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            throw new IllegalArgumentException("Product with id " + id + " does not exist");
        }
        product.setProductName(productDTO.productName());
        product.setPrice(productDTO.price());
        product.setWeight(productDTO.weight());

        System.out.println("Updated " + product.toString());

        productRepository.save(product);
        return product;
    }
}