package com.example.menu_makanan.service;

import com.example.menu_makanan.model.Barang;
import com.example.menu_makanan.model.Buyer;
import com.example.menu_makanan.repository.BarangRepository;
import com.example.menu_makanan.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {

    @Autowired
    BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;

    }
    public Buyer add(Buyer add) {
        Buyer buyer = new Buyer();
        buyer.setNama(add.getNama());
        buyer.setNama_barang(add.getNama_barang());
        buyer.setJumlah(add.getJumlah());
        buyer.setAlamat(add.getAlamat());

        System.out.println("Sebelum save: " + buyer);
        Buyer saved = buyerRepository.save(buyer);
        System.out.println("Setelah save: " + saved);
        return saved;
    }

    public List<Buyer> getAllBuyer() {
        return buyerRepository.findAll();
    }
}
