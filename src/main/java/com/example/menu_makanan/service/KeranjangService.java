package com.example.menu_makanan.service;

import com.example.menu_makanan.model.Barang;
import com.example.menu_makanan.model.Keranjang;
import com.example.menu_makanan.repository.BarangRepository;
import com.example.menu_makanan.repository.KeranjangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KeranjangService {
    @Autowired
    private BarangRepository barangRepo;

    @Autowired
    private KeranjangRepository keranjangtRepo;

    public Keranjang addBarangToKeranjang(Long barangId) {
        Optional<Barang> optionalBarang = barangRepo.findById(barangId);

        if (optionalBarang.isPresent()) {
            Barang barang = optionalBarang.get();

            if (barang.getStok_barang() > 0) {
                barang.setStok_barang(barang.getStok_barang() - 1);
                barangRepo.save(barang);

                Keranjang keranjang = new Keranjang();
                keranjang.setNama_barang(barang.getNama_barang());
                keranjang.setJumlah(1);
                keranjang.setHarga_barang(barang.getHarga_barang());
                return keranjangtRepo.save(keranjang);
            } else {
                throw new RuntimeException("Stok barang tidak mencukupi");
            }
        } else {
            throw new RuntimeException("Barang dengan ID " + barangId + " tidak ditemukan");
        }
    }
}
