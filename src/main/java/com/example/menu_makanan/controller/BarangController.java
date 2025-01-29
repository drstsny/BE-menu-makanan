package com.example.menu_makanan.controller;

import com.example.menu_makanan.model.Barang;
import com.example.menu_makanan.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/barang")
@CrossOrigin(origins = "http://localhost:5173")
public class BarangController {
    @Autowired
    private BarangService barangService;

    @PostMapping
    public Barang add(@RequestBody Barang ad) {
        System.out.println("Data yang diterima: " + ad);
        return barangService.add(ad);
    }

    @GetMapping("/{id}")
    public Barang getById(@PathVariable("id") Long id) {
        return barangService.getById(id);
    }

    @GetMapping
    public List<Barang> getAllBarang() {
        return barangService.getAllBarang();
    }

    @GetMapping("/makanan")
    public List<Barang> getAllMakanan() {
        return barangService.getAllMakanan();
    }

    @GetMapping("/minuman")
    public List<Barang> getAllMinuman() {
        return barangService.getAllMinuman();
    }

    @GetMapping("/api/barang")
    public ResponseEntity<?> getBarangByNama_barang(@RequestParam(required = false) String nama_barang) {
        try {
            List<Barang> result = barangService.getBarangByNama_barang(nama_barang);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Terjadi kesalahan pada server: " + e.getMessage());
        }
    }

    @GetMapping("/makananRingan")
    public List<Barang> getAllMakanan_ringan() {
        return barangService.getAllMakanan_ringan();
    }

    @PostMapping("/api/barang/buy/{id}")
    public ResponseEntity<String> buyBarang(@PathVariable Long id, @RequestBody Map<String, Object> payload) {
        if (!payload.containsKey("jumlah")) {
            return ResponseEntity.badRequest().body("Key 'jumlah' tidak ditemukan dalam request.");
        }

        Integer jumlah = (Integer) payload.getOrDefault("jumlah", 0);
        if (jumlah == 0) {
            return ResponseEntity.badRequest().body("jumlah harus berupa angka positif.");
        }

        try {
            barangService.buyBarang(id, jumlah);
            return ResponseEntity.ok("Barang berhasil dibeli.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Terjadi kesalahan pada server.");
        }
    }

    @PutMapping("/{id}")
    public Barang edit(@PathVariable("id") Long id, @RequestBody Barang tugas) {
        return barangService.edit(id, tugas);
    }


    @DeleteMapping("/api/barang/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") Long id) {
        return barangService.delete(id);
    }

}
