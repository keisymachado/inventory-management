package com.academic.inventory.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.academic.inventory.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long >   {

}
