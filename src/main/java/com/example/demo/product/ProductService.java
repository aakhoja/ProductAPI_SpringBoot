package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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
    @Transactional
    public void updateProduct(Long productId, String name, String sku) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("Product with ID : " + productId +" does not exist."));

        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(product.getProductName(),name)) {
            product.setProductName(name);
        }

        if(sku != null &&
                sku.length() > 0 &&
                !Objects.equals(product.getSku(),sku)){
            product.setSku(sku);
        }
    }
}

