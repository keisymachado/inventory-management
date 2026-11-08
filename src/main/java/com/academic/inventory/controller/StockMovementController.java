package com.academic.inventory.controller;

import com.academic.inventory.dto.StockMovementRequest;
import com.academic.inventory.entities.StockMovement;
import com.academic.inventory.service.StockMovementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockMovementController {

    private final StockMovementService stockMovementService;

    public StockMovementController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    @GetMapping("/stock-movements")
    public List<StockMovement> findAll() {
        return stockMovementService.findAll();
    }

    @PostMapping("/stock-movements")
    public StockMovement register(@RequestBody StockMovementRequest request) {
        return stockMovementService.register(
                request.productId(),
                request.type(),
                request.quantity()
        );
    }
}