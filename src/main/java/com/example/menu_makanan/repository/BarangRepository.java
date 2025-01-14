package com.example.menu_makanan.repository;


import com.example.menu_makanan.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepository extends JpaRepository<Barang, Long> {
}
