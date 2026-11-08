package com.academic.inventory.service;

import com.academic.inventory.entities.Supplier;
import com.academic.inventory.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Supplier findById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier update(Long id, Supplier data) {
        Supplier supplier = findById(id);
        supplier.setName(data.getName());
        supplier.setPhone(data.getPhone());
        supplier.setEmail(data.getEmail());
        return supplierRepository.save(supplier);
    }

    public void deleteById(Long id) {
        findById(id);
        supplierRepository.deleteById(id);
    }
}