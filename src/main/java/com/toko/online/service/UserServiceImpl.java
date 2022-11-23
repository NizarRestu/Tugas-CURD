package com.toko.online.service;

import com.toko.online.exception.InternalErrorException;
import com.toko.online.exception.NotFoundException;
import com.toko.online.model.TableUser;
import com.toko.online.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Object getAllUser() {
        return userRepository.findAll();
    }


    @Override
    public TableUser addUser(TableUser tableUser) {
            String email = tableUser.getEmail();
            var validasi =  userRepository.findByEmail(email);
            if ( validasi.isPresent()) {
                throw new InternalErrorException("Email Already Axist");
            } else {
                return userRepository.save(tableUser);
            }
    }



    @Override
    public Object getUser(Integer id) {
        var response = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Tidak Ditemukan"));
        try {
            return userRepository.save(response);
        } catch (Exception e) {
            throw new InternalErrorException("Kesalahan Muncul Data");
        }
    }

    @Override
    public TableUser editUser(Integer id, String username, String email, Integer age, String address, Integer phoneNumber) {
        TableUser tableUser = userRepository.findById(id).get();
        tableUser.setUsername(username);
        tableUser.setEmail(email);
        tableUser.setAge(age);
        tableUser.setAddress(address);
        tableUser.setPhoneNumber(phoneNumber);
        return userRepository.save(tableUser);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}
