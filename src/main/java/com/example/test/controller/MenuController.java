package com.example.test.controller;

import com.example.test.controller.model.MenuDto;
import com.example.test.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1.0/menu")

public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping()
    public ResponseEntity <List<MenuDto>> getMenus (Integer idMenu) {
        List<MenuDto> menus = menuService.getMenus(idMenu);
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/{idMenu}")
    public ResponseEntity <MenuDto> getMenuId (@PathVariable Integer idMenu){
        MenuDto menu = menuService.getMenu(idMenu);
        return ResponseEntity.ok(menu);
    }

    @PutMapping ("/{idMenu}")
    public ResponseEntity<MenuDto> updateMenu (@RequestBody MenuDto cambioMenu, @PathVariable Integer idMenu){
        MenuDto menu = menuService.updateMenu(cambioMenu,idMenu);
        return ResponseEntity.ok(menu);
    }

    @PostMapping ()
    public ResponseEntity<MenuDto> createMenu (@RequestBody MenuDto nuevoMenu){
        MenuDto menu = menuService.createMenu(nuevoMenu);
        return ResponseEntity.ok(menu);
    }

    @DeleteMapping ("/{idMenu}")
    public ResponseEntity<MenuDto> deleteMenu (@PathVariable Integer idTienda){
        MenuDto menu = menuService.deleteMenu(idTienda);
        return ResponseEntity.ok(menu);
    }



}
