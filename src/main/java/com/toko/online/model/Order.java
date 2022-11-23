package com.toko.online.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    @Column(name = "Tanggal_Dibuat", updatable = false)
    private Date tanggalDibuat;

    @Column(name = "Nama_Barang", nullable = false)
    private String namaBarang;

    @Column(name = "Harga")
    private String harga;

    @Column(name = "Pemilik" , nullable = false)
    private String pemilik ;

    public Order() {
    }

    public Order(Date tanggalDibuat, String namaBarang, String harga, String pemilik) {
        this.tanggalDibuat = tanggalDibuat;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.pemilik = pemilik;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    public Date getTanggalDibuat() {
        return tanggalDibuat;
    }

    public void setTanggalDibuat(Date tanggalDibuat) {
        this.tanggalDibuat = tanggalDibuat;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + Id +
                ", tanggalDibuat=" + tanggalDibuat +
                ", namaBarang='" + namaBarang + '\'' +
                ", harga='" + harga + '\'' +
                ", pemilik='" + pemilik + '\'' +
                '}';
    }
}
