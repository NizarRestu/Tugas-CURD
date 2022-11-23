package com.toko.online.service;

import com.toko.online.model.Order;

public interface OrderService {

    Object getAllOrder();

    Order addOrder(Order order);

    Order editOrder(Integer Id, String namaBarang, String harga);

    Object getOrder(Integer Id);

    void deleteOrder(Integer Id);
}
