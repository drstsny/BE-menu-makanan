package com.example.menu_makanan.repository;

import com.example.menu_makanan.model.Keranjang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeranjangRepository extends JpaRepository<Keranjang, Long> {
}
