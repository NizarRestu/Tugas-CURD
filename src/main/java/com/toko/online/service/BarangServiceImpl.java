package com.toko.online.service;

import com.toko.online.exception.InternalErrorException;
import com.toko.online.exception.NotFoundException;
import com.toko.online.model.TableBarang;
import com.toko.online.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BarangServiceImpl implements BarangService{

    @Autowired
    BarangRepository barangRepository;

    @Override
    public Object getAllBarang() {
        return barangRepository.findAll();
    }

    @Override
    public TableBarang addBarang(TableBarang tableBarang) {

        return barangRepository.save(tableBarang);
    }

    @Override
    public Object getBarang(Integer id) {
        var response = barangRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Tidak Ditemukan"));
        try {
            return barangRepository.save(response);
        } catch (Exception e) {
            throw new InternalErrorException("Kesalahan Muncul Data");
        }
    }

    @Override
    public TableBarang editBarang(Integer id, String name, Float price, Integer count, Integer rating, String description, boolean publish) {
        TableBarang tableBarang = barangRepository.findById(id).get();
        tableBarang.setName(name);
        tableBarang.setPrice(price);
        tableBarang.setCount(count);
        tableBarang.setRating(rating);
        tableBarang.setDescription(description);
        tableBarang.setPublish(publish);
        return barangRepository.save(tableBarang);
    }

    @Override
    public void deleteBarang(Integer id) {
        barangRepository.deleteById(id);
    }


}
