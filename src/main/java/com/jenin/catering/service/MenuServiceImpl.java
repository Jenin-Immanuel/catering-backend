package com.jenin.catering.service;

import com.jenin.catering.model.Menu;
import com.jenin.catering.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService{
    private final MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getMenu() {
        return menuRepository.findAll();
    }

    @Override
    public Menu getMenuItemById(Long id) {
        Optional<Menu> menuOptional = menuRepository.findById(id);
        if (menuOptional.isEmpty()) {
            throw new RuntimeException("I am a bad boy");
        }
        else {
            return new Menu(
                    menuOptional.get().getItemId(),
                    menuOptional.get().getItemName(),
                    menuOptional.get().getPricePerPlate()
            );
        }
    }
}
