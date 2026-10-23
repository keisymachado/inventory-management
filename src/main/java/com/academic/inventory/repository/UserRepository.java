package com.academic.inventory.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.academic.inventory.entities.User;

public interface UserRepository extends  JpaRepository <User, Long>{
}
