package com.example.test.repository;

import com.example.test.model.Tienda;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TiendaRepository extends JpaRepository<Tienda, Integer> {

    @Value("SELECT * FROM tienda WHERE ciudad = (:ciudad)")
    List<Tienda> getTiendasByCiudad(String ciudad);
}


