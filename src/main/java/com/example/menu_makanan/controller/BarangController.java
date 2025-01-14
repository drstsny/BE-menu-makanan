package com.example.menu_makanan.controller;

import com.example.menu_makanan.model.Barang;
import com.example.menu_makanan.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/barang")
@CrossOrigin(origins = "http://localhost:5175")
public class BarangController {
    @Autowired
    private BarangService barangService;

    @PostMapping
    public Barang add(@RequestBody Barang ad) {
        System.out.println("Data yang diterima: " + ad);
        return barangService.add(ad);
    }

    @GetMapping ("/{id}")
    public Barang getById(@PathVariable("id") Long id ) {
        return barangService.getById(id);
    }

    @GetMapping
    public List<Barang> getAll() {
        return barangService.getAll();
    }

    @PutMapping("/{id}")
    public Barang edit(@PathVariable("id") Long id, @RequestBody Barang tugas) {
        return barangService.edit(id, tugas);
    }

    @DeleteMapping("/api/barang/{id}")
    public Map<String, Boolean> delete(@PathVariable("id")  Long id) {
        return  barangService.delete(id);
    }
}
