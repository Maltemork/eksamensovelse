package edu.eksamensopgave.eksamensopgave.productOrder;

import edu.eksamensopgave.eksamensopgave.product.Product;

public class ProductOrderDTO {
    private int orderId;
    private int quantity;
    private Product product;

    public ProductOrderDTO() {
    }

    public ProductOrderDTO(int orderId, int quantity, Product product) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.product = product;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}