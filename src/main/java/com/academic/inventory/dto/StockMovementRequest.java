package com.academic.inventory.dto;


public record StockMovementRequest(Long productId, String type, int quantity) {
}
