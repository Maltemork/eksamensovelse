package edu.eksamensopgave.eksamensopgave.product;

import java.math.BigDecimal;

public record ProductDTO(int productId, String productName, BigDecimal price, double weight) {
}