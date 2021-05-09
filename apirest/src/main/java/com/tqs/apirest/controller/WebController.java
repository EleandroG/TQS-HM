package com.tqs.apirest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tqs.apirest.model.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
class WebController {

    @Autowired
    CitiesController citiesController = new CitiesController();

    // lisbon page
    @RequestMapping(method = RequestMethod.GET, value = "/")
    String home(Model model) throws JsonProcessingException {
        Cities pedido = citiesController.getCitiesByIdx((long) 8379);
        model.addAttribute("info", pedido);
        citiesController.incrementStats();
        return "lisbon";
    }

    // madrid page
    @RequestMapping(method = RequestMethod.GET, value = "/madrid")
    String mapa(Model model) throws JsonProcessingException {
        Cities pedido = citiesController.getCitiesByIdx((long) 5725);
        model.addAttribute("info", pedido);
        citiesController.incrementStats();
        return "madrid";
    }
}
