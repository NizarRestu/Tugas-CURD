package com.toko.online.repository;

import com.toko.online.model.TableUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<TableUser, Integer> {
   Optional <TableUser> findByEmail(String email);
}
