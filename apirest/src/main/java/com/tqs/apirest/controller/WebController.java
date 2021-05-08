package com.tqs.apirest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tqs.apirest.model.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class WebController {

    @Autowired
    CitiesController cityController = new CitiesController();

    // lisbon page
    @RequestMapping(method = RequestMethod.GET, value = "/")
    String home(Model model) throws JsonProcessingException {
        Cities pedido = cityController.getCitiesById((long) 8373);
        model.addAttribute("info", pedido);
        cityController.incrementStatsCount();
        return "porto";
    }

    // madrid page
    @RequestMapping(method = RequestMethod.GET, value = "/madrid")
    String mapa(Model model) throws JsonProcessingException {
        Cities pedido = cityController.getCitiesById((long) 5725);
        model.addAttribute("info", pedido);
        cityController.incrementStatsCount();
        return "madrid";
    }
}
