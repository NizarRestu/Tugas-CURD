package com.toko.online.repository;

import com.toko.online.model.TableBarang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepository extends JpaRepository<TableBarang , Integer> {
}
