package edu.eksamensopgave.eksamensopgave.product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
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

    public ProductDTO getProductByName(String productName) {
       Product foundProduct = productRepository.findByProductNameIgnoreCase(productName);
         return new ProductDTO(foundProduct.getProductId(), foundProduct.getProductName(), foundProduct.getPrice(), foundProduct.getWeight());
    }
}