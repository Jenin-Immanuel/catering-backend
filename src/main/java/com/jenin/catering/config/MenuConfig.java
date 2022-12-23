package com.jenin.catering.config;

import com.jenin.catering.model.ExtraServices;
import com.jenin.catering.model.Menu;
import com.jenin.catering.repository.ExtraServicesRepository;
import com.jenin.catering.repository.MenuRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MenuConfig {
    @Bean
    CommandLineRunner commandLineRunner(MenuRepository menuRepository, ExtraServicesRepository extraServicesRepository) {
        return args -> {
            Menu Idly = new Menu(
                    "Idly",
                    20.0
            );
            Menu PlainDosa = new Menu(
                    "Plain Dosa",
                    30.0
            );
            Menu MasalaDosa = new Menu(
                    "Masala dosa",
                    40.0
            );
            Menu Porotta = new Menu(
                    "Porotta Set",
                    40.0
            );
            Menu PlainBiriyani= new Menu(
                    "Plain Biriyani",
                    40.0
            );
            Menu EggBiriyani = new Menu(
                    "Egg Biriyani",
                    50.0
            );
            Menu MushroomBiriyani = new Menu(
                    "Mushroom Biriyani",
                    50.0
            );
            Menu TomatoRice = new Menu(
                    "TomatoRice",
                    30.0
            );
            Menu Chappathi = new Menu(
                    "Chappathi",
                    20.0
            );
            Menu PannerChappathi = new Menu(
                    "Panner Chappathi",
                    40.0
            );

            menuRepository.saveAll(List.of(Idly, PlainDosa, MasalaDosa, Porotta, PlainBiriyani, EggBiriyani, MushroomBiriyani, TomatoRice, Chappathi, PannerChappathi));

            ExtraServices transport = new ExtraServices(
                    1L,
                    "Transport",
                    5000.00
            );

            ExtraServices decoration = new ExtraServices(
                    2L,
                    "Decoration",
                    10000.00
            );
            ExtraServices felicitation = new ExtraServices(
                    3L,
                    "Felicitation",
                    7500.00
            );

            extraServicesRepository.saveAll(List.of(transport, decoration, felicitation));
        };
    }
}
