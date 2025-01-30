package com.example.menu_makanan.controller;


import com.example.menu_makanan.model.Keranjang;
import com.example.menu_makanan.service.KeranjangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/keranjang")
@CrossOrigin(origins = "http://localhost:5173")
public class KeranjangController {
    @Autowired
    private KeranjangService keranjangService;

    @PostMapping("/{barangId}")
    public Keranjang addBarangToKeranjang(@PathVariable Long barangId) {
        return keranjangService.addBarangToKeranjang(barangId);
    }

    @GetMapping
    public List<Keranjang> getAllKeranjang() {
        return keranjangService.getAllKeranjang();
    }

    @DeleteMapping("/api/keranjang/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") Long id) {
        return keranjangService.delete(id);
    }

    @GetMapping("/api/keranjang")
    public ResponseEntity<?> getKeranjangByNama_barang(@RequestParam(required = false) String nama_barang) {
        try {
            List<Keranjang> result = keranjangService.getKeranjangByNama_barang(nama_barang);
            return ResponseEntity.ok(result);
        }catch (Exception e) {
            return ResponseEntity.status(500).body("Terjadi kesalahan pada server" + e.getMessage());
        }
    }
}
