package com.toko.online.service;

import com.toko.online.model.TableUser;

public interface UserService {

    Object getAllUser();

    TableUser addUser(TableUser tableUser);

    Object getUser(Integer id);

    TableUser editUser(Integer id, String username , String email, Integer age, String address, Integer phoneNumber );

    void deleteUser(Integer id);


}
