package edu.eksamensopgave.eksamensopgave.productOrder;

import edu.eksamensopgave.eksamensopgave.product.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productOrders")
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @GetMapping
    public ResponseEntity<List<ProductOrderDTO>> getAllProductOrders() {
        List<ProductOrderDTO> productOrders = productOrderService.getAllProductOrders();

        List<ProductOrderDTO> productOrderDTOs = productOrders.stream()
                .map(productOrder -> new ProductOrderDTO(productOrder.getOrderId(), productOrder.getQuantity(), productOrder.getProduct()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(productOrderDTOs);
    }
}
