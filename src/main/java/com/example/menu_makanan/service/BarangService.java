package com.example.menu_makanan.service;

import com.example.menu_makanan.exception.NotFoundException;
import com.example.menu_makanan.model.Barang;
import com.example.menu_makanan.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BarangService {
    @Autowired
    BarangRepository barangRepo;

    public BarangService(BarangRepository barangRepository) {
        this.barangRepo = barangRepository;

    }
    public Barang add(Barang ad) {
        Barang barang = new Barang();
        barang.setDeskripsi_barang(ad.getDeskripsi_barang());
        barang.setHarga_barang(ad.getHarga_barang());
        barang.setJenis_barang(ad.getJenis_barang());
        barang.setNama_barang(ad.getNama_barang());
        barang.setStok_barang(ad.getStok_barang());
        barang.setTanggal_kadaluarsa(ad.getTanggal_kadaluarsa());

        System.out.println("Sebelum save: " + barang);
        Barang saved = barangRepo.save(barang);
        System.out.println("Setelah save: " + saved);
        return saved;
    }

    public  Barang getById(Long id) {
        return barangRepo.findById(id).orElseThrow(() -> new NotFoundException("id Not Found"));
    }

    public List<Barang> getAll() {
        return barangRepo.findAll();
    }

    public  Barang edit(Long id, Barang user) {
        Barang update = barangRepo.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));
        update.setNama_barang(user.getNama_barang());
        update.setStok_barang(user.getStok_barang());
        update.setDeskripsi_barang(user.getDeskripsi_barang());
        update.setJenis_barang(user.getJenis_barang());
        update.setTanggal_kadaluarsa(user.getTanggal_kadaluarsa());
        update.setHarga_barang(user.getHarga_barang());
        return barangRepo.save(update);
    }

    public Map<String, Boolean> delete(Long id){
        try {
            barangRepo.deleteById(id);
            Map<String , Boolean> map = new HashMap<>();
            map.put("Deleted", true);
            return map;
        } catch (Exception e){
            return null;
        }
    }
}
