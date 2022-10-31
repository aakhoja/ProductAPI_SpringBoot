package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/product")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProduct();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }


    @DeleteMapping
    public void deleteProduct(@PathVariable("productID") Long productID){
        productService.deleteProduct(productID);
    }
    @PutMapping(path = "api/v1/update")
    public void updateProduct(
            @PathVariable("productID") Long productId,
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) String productSku) {
        productService.updateProduct(productId,productName,productSku);

    }
}
