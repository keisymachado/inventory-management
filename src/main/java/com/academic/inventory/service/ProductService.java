package com.academic.inventory.service;

import com.academic.inventory.entities.Product;
import com.academic.inventory.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //make the object atomatically
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("product not found"));

    }
    public void deleteById(Long id){
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);

    }

    public Product  save(Product product){
        return productRepository.save(product);

    }

    public Product update(Long id,Product data ){
        Product product = findById(id);
        product.setName(data.getName());
        product.setSku(data.getSku());
        product.setAmount(data.getAmount());
        product.setPrice(data.getPrice());
        return productRepository.save(product);

    }


}
