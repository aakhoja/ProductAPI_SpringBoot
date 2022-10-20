package com.example.demo.product;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(name="product_sequence",
                        sequenceName="product_sequence",
                        allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String sku;
    private String productName;
    private Double price;
    private Integer quantity;

    public Product() {
    }

    public Product(Long id,
                   String sku,
                   String productName,
                   Double price,
                   Integer quantity) {
        this.id = id;
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String sku,
                   String productName,
                   Double price,
                   Integer quantity) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sku=" + sku +
                ", name=" + productName +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
