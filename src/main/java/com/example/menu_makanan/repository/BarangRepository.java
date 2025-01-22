package com.example.menu_makanan.repository;


import com.example.menu_makanan.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarangRepository extends JpaRepository<Barang, Long> {

    @Query("SELECT b FROM Barang b WHERE b.nama_barang = :nama_barang")
    List<Barang> findByNama_barang(@Param("nama_barang") String nama_barang);

    @Query("SELECT b FROM Barang b WHERE b.jenis_barang = :jenis_barang")
    List<Barang> findByJenis(@Param("jenis_barang") String jenis_barang);

}

