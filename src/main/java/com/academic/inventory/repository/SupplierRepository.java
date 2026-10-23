package com.academic.inventory.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.academic.inventory.entities.Supplier;


public interface SupplierRepository extends JpaRepository <Supplier, Long> {

}
