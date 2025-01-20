package com.example.menu_makanan.controller;

import com.example.menu_makanan.model.Barang;
import com.example.menu_makanan.model.Buyer;
import com.example.menu_makanan.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/buyer")
@CrossOrigin(origins = "http://localhost:5175")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @PostMapping("/buyer")
    public Buyer add(@RequestBody Buyer ada) {
        System.out.println("Data yang diterima: " + ada);
        return buyerService.add(ada);
    }

    @GetMapping
    public List<Buyer> getAllBuyer() {
        return buyerService.getAllBuyer();
    }
}
