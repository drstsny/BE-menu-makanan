package com.example.menu_makanan.repository;

import com.example.menu_makanan.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository <Buyer , Long>{
}
