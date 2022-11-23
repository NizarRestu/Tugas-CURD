package com.toko.online.service;

import com.toko.online.exception.InternalErrorException;
import com.toko.online.exception.NotFoundException;
import com.toko.online.model.Order;
import com.toko.online.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Object getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order addOrder(Order order) {
        String test = order.getPemilik();
        var validasi = orderRepository.findByPemilik(test);
        if (validasi.isPresent()) {
            throw new InternalErrorException("Email Already Axist");
        }
        return orderRepository.save(order);
    }

    @Override
    public Object getOrder(Integer Id) {
        var response = orderRepository.findById(Id).orElseThrow(() -> new NotFoundException("Id Tidak Ditemukan"));
        return orderRepository.save(response);
    }

    @Override
    public Order editOrder(Integer Id, String namaBarang, String harga) {
        Order order = orderRepository.findById(Id).get();
        order.setNamaBarang(namaBarang);
        order.setHarga(harga);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer Id) {
        orderRepository.deleteById(Id);
    }
}
