package com.example.menu_makanan.repository;

import com.example.menu_makanan.model.Keranjang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KeranjangRepository extends JpaRepository<Keranjang, Long> {

    @Query("SELECT b FROM Keranjang b WHERE b.nama_barang = :nama_barang")
    List<Keranjang> findByNama_barang (@Param("nama_barang") String nama_barang);
}
