package com.academic.inventory.service;
import com.academic.inventory.entities.Product;
import com.academic.inventory.entities.StockMovement;
import com.academic.inventory.repository.StockMovementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockMovementService {

    private final StockMovementRepository stockMovementRepository;
    private final ProductService productService;

    public StockMovementService(StockMovementRepository stockMovementRepository,
                                ProductService productService) {
        this.stockMovementRepository = stockMovementRepository;
        this.productService = productService;
    }

    public List<StockMovement> findAll() {
        return stockMovementRepository.findAll();
    }

    @Transactional
    public StockMovement register(Long productId, String type, int quantity) {
        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be greater than zero");
        }

        Product product = productService.findById(productId);

        if ("ENTRY".equals(type)) {
            product.setAmount(product.getAmount() + quantity);
        } else if ("EXIT".equals(type)) {
            if (quantity > product.getAmount()) {
                throw new RuntimeException("Not enough stock");
            }
            product.setAmount(product.getAmount() - quantity);
        } else {
            throw new RuntimeException("Type must be ENTRY or EXIT");
        }

        productService.save(product);

        StockMovement movement = new StockMovement();
        movement.setType(type);
        movement.setQuantity(quantity);
        movement.setMovementDate(LocalDateTime.now());
        movement.setProduct(product);

        return stockMovementRepository.save(movement);
    }
}