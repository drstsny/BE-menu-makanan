package com.example.menu_makanan.controller;


import com.example.menu_makanan.model.Keranjang;
import com.example.menu_makanan.service.KeranjangService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
