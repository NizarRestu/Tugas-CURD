package com.toko.online.service;

import com.toko.online.model.TableBarang;

public interface BarangService {
    Object getAllBarang();

    TableBarang addBarang(TableBarang tableBarang);

    Object getBarang(Integer id);

    TableBarang editBarang(Integer id, String name, Float price, Integer count, Integer rating, String description, boolean publish);

    void deleteBarang(Integer id);

}
