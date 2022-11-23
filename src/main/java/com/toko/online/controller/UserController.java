package com.toko.online.controller;


import com.toko.online.exception.InternalErrorException;
import com.toko.online.model.TableUser;
import com.toko.online.response.ResponseHelper;
import com.toko.online.response.commonResponse;
import com.toko.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Cacheable;

@RestController
@RequestMapping( "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Object getAllUser() {
        try {
            return ResponseHelper.ok(userService.getAllUser());
        } catch (Exception e) {
            throw new InternalErrorException("Kesalahan muncul data");
        }
    }

    @GetMapping("/{id}")
    public Object getUser(@PathVariable("id") Integer id) {
        return ResponseHelper.ok(userService.getUser(id)) ;
    }

    @PostMapping
    public Object addUser(@RequestBody TableUser tableUser) {
            return ResponseHelper.ok(userService.addUser(tableUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<commonResponse<TableUser>> editUser(@PathVariable("id") Integer id, @RequestBody TableUser tableUser) {
        return ResponseHelper.ok(userService.editUser(id, tableUser.getUsername(), tableUser.getEmail(),tableUser.getAge(),tableUser.getAddress(), tableUser.getPhoneNumber()));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }
}
