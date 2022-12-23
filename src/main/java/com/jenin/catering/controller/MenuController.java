package com.jenin.catering.controller;

import com.jenin.catering.model.Menu;
import com.jenin.catering.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {
    @Autowired
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<Menu> getAllItems() {
        return menuService.getMenu();
    }
}
