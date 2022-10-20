package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private final ProductRepository productRepository;


    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    public void addNewProduct(Product product){

        Optional<Product> productSku = productRepository.findProductBySku(product.getSku());

        if(productSku.isPresent())
            throw new IllegalStateException("SKU is already present.");
        productRepository.save(product);
    }

    public void deleteProduct(Long productID) {
        if(productRepository.existsById(productID))
            productRepository.deleteById(productID);
        else
            throw new IllegalStateException("Product with ID :" + productID + " does not exist");

    }

    public void updateProduct(Long productId, String productName, String productSku) {
        if(productRepository.existsById(productId)){

        }
    }
}

