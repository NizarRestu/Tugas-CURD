package com.toko.online.controller;

import com.toko.online.exception.InternalErrorException;
import com.toko.online.model.TableBarang;
import com.toko.online.response.ResponseHelper;
import com.toko.online.response.commonResponse;
import com.toko.online.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barang")
public class BarangController {
    @Autowired
    private BarangService barangService;

    @GetMapping("/all")
    public Object getAllBarang() {
        try {
            return ResponseHelper.ok(barangService.getAllBarang());
        } catch (Exception e) {
            throw new InternalErrorException("Kesalahan muncul data");
        }
    }

    @GetMapping("/{id}")
    public Object getBarang(@PathVariable("id") Integer id) {
        return ResponseHelper.ok(barangService.getBarang(id)) ;
    }

    @PostMapping
    public ResponseEntity<commonResponse<TableBarang>> addBarang(@RequestBody TableBarang tableBarang) {
        return ResponseHelper.ok(barangService.addBarang(tableBarang));
    }

    @PutMapping("/{id}")
    public ResponseEntity<commonResponse<TableBarang>> editBarang(@PathVariable("id") Integer id, @RequestBody TableBarang tableBarang) {
        return ResponseHelper.ok(barangService.editBarang(id, tableBarang.getName(), tableBarang.getPrice(),tableBarang.getCount(),tableBarang.getRating(), tableBarang.getDescription(),tableBarang.getPublish()));
    }

    @DeleteMapping("/{id}")
    public void deleteBarang(@PathVariable("id") Integer id) {
        barangService.deleteBarang(id);
    }
}
