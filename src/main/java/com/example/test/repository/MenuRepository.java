package com.example.test.repository;

import com.example.test.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository <Menu,Integer> {
    List<Menu> getMenuByIdMenu (Integer idMenu);
}
