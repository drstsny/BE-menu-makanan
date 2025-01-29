package com.example.menu_makanan.model;

import javax.persistence.*;

@Entity
@Table(name = "keranjang")
public class Keranjang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nama_barang;

    @Column(nullable = false)
    private Integer jumlah;

    @Column(nullable = false)
    private Float harga_barang;

    @Column(nullable = false)
    private String link_gambar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Float getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(float harga_barang) {
        this.harga_barang = harga_barang;
    }

    public String getLink_gambar() {
        return link_gambar;
    }

    public void setLink_gambar(String link_gambar) {
        this.link_gambar = link_gambar;
    }
}

