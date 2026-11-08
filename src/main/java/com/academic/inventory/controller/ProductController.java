package com.academic.inventory.controller;
import com.academic.inventory.entities.Product;
import com.academic.inventory.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping("/products")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/products/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteById(id);
    }
}