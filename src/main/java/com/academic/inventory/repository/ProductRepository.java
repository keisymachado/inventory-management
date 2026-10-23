package com.academic.inventory.repository;

import com.academic.inventory.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository  extends JpaRepository<Product, Long> {
}
// expends hereda toda la lista de metodos de jpa
