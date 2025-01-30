package com.example.menu_makanan.service;

import com.example.menu_makanan.model.Barang;
import com.example.menu_makanan.model.Keranjang;
import com.example.menu_makanan.repository.BarangRepository;
import com.example.menu_makanan.repository.KeranjangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class KeranjangService {
    @Autowired
    private BarangRepository barangRepo;

    @Autowired
    private KeranjangRepository keranjangtRepo;

    public List<Keranjang> getAllKeranjang() {
        return keranjangtRepo.findAll();
    }

    public List<Keranjang> getKeranjangByNama_barang(String nama_barang) {
        if (nama_barang == null || nama_barang.isEmpty()) {
            return keranjangtRepo.findAll();
        }
        return keranjangtRepo.findByNama_barang(nama_barang);
    }

    public Keranjang addBarangToKeranjang(Long barangId) {
        Optional<Barang> optionalBarang = barangRepo.findById(barangId);

        if (optionalBarang.isPresent()) {
            Barang barang = optionalBarang.get();

            if (barang.getStok_barang() > 0) {
                barang.setStok_barang(barang.getStok_barang() - 1);
                barangRepo.save(barang);

                Keranjang keranjang = new Keranjang();
                keranjang.setNama_barang(barang.getNama_barang());
                keranjang.setLink_gambar(barang.getLink_gambar());
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
    public Map<String, Boolean> delete(Long id){
        try {
            keranjangtRepo.deleteById(id);
            Map<String , Boolean> map = new HashMap<>();
            map.put("Deleted", true);
            return map;
        } catch (Exception e){
            return null;
        }
    }
}
