package com.toko.online.controller;


import com.toko.online.model.Order;
import com.toko.online.response.ResponseHelper;
import com.toko.online.response.commonResponse;
import com.toko.online.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
   private OrderService orderService;

    @PostMapping
    public Object addOrder(@RequestBody Order order) {
        return ResponseHelper.ok(orderService.addOrder(order));
    }
    @GetMapping("/")
    public Object getAllOrder(){
        return ResponseHelper.ok(orderService.getAllOrder());
    }

    @GetMapping("/{Id}")
    public Object getUser(@PathVariable("Id") Integer Id) {
        return ResponseHelper.ok(orderService.getOrder(Id)) ;
    }

    @PutMapping("/{Id}")
    public ResponseEntity<commonResponse<Order>> editOrder(@PathVariable("Id") Integer Id, @RequestBody Order order) {
        return ResponseHelper.ok(orderService.editOrder(Id,order.getNamaBarang(),order.getHarga()));
    }

    @DeleteMapping("/{Id}")
    public void deleteOrder(@PathVariable("Id") Integer Id) {
        orderService.deleteOrder(Id);
    }
}
