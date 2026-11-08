package com.academic.inventory.controller;
import com.academic.inventory.entities.Supplier;
import com.academic.inventory.service.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/suppliers")
    public List<Supplier> findAll() {
        return supplierService.findAll();
    }

    @GetMapping("/suppliers/{id}")
    public Supplier findById(@PathVariable Long id) {
        return supplierService.findById(id);
    }

    @PostMapping("/suppliers")
    public Supplier save(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    @PutMapping("/suppliers/{id}")
    public Supplier update(@PathVariable Long id, @RequestBody Supplier supplier) {
        return supplierService.update(id, supplier);
    }

    @DeleteMapping("/suppliers/{id}")
    public void delete(@PathVariable Long id) {
        supplierService.deleteById(id);
    }
}