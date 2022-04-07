package com.example.test.service;

import com.example.test.controller.model.MenuDto;

import java.util.List;

public interface MenuService {

    List<MenuDto> getMenus (Integer idTienda);

    MenuDto getMenu (Integer idMenu);

    MenuDto updateMenu (MenuDto cambioMenu, Integer idMenu);

    MenuDto createMenu (MenuDto nuevoMenu);

    MenuDto deleteMenu (Integer idMenu);


}
