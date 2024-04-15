package edu.eksamensopgave.eksamensopgave.product;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(int id) {
        return productService.getProduct(id);
    }

    @GetMapping("/{productName}")
    public List<ProductDTO> getProductByName(@PathVariable String productName) {
        return productService.getProductByName(productName);
    }

    @PostMapping
    public Product addProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }
}
