package com.toko.online.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class TableUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "age",nullable = false)
    private Integer age;

    @Lob
    @Column(name = "address")
    private String address;

    @Column(name = "phone_number",nullable = false)
    private Integer phoneNumber;

    public TableUser() {
    }

    public TableUser(String username, String email, Integer age, String address, Integer phoneNumber) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "TableUser{" + "id=" + id + ", username='" + username + '\'' + ", email='" + email + '\'' + ", age=" + age + ", address='" + address + '\'' + ", phoneNumber=" + phoneNumber + '}';
    }
}
