package com.example.test.service.impl;

import com.example.test.controller.model.MenuDto;
import com.example.test.model.Menu;
import com.example.test.repository.MenuRepository;
import com.example.test.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<MenuDto> getMenus(Integer idTienda) {
        List<Menu> menus;
        if (idTienda != null){
            menus = menuRepository.getMenuByIdMenu(idTienda);
        }

        return null;
    }

    @Override
    public MenuDto getMenu(Integer idMenu) {
        return null;
    }

    @Override
    public MenuDto updateMenu(MenuDto cambioMenu, Integer idMenu) {
        return null;
    }

    @Override
    public MenuDto createMenu(MenuDto nuevoMenu) {
        return null;
    }

    @Override
    public MenuDto deleteMenu(Integer idMenu) {
        return null;
    }
}
