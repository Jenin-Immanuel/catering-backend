package com.jenin.catering.service;

import com.jenin.catering.model.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenu();

    Menu getMenuItemById(Long id);
}
