package com.example.menu_makanan.controller;


import com.example.menu_makanan.model.Keranjang;
import com.example.menu_makanan.service.KeranjangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/keranjang")
@CrossOrigin(origins = "http://localhost:5175")
public class KeranjangController {
    @Autowired
    private KeranjangService cartService;

    @PostMapping("/{barangId}")
    public Keranjang addBarangToKeranjang(@PathVariable Long barangId) {
        return cartService.addBarangToKeranjang(barangId);
    }
}
