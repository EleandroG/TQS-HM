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

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    String homePage(Model model) throws JsonProcessingException {
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/madrid")
    String mapa(Model model) throws JsonProcessingException {
        Cities request = citiesController.citiesByIdx((long) 5725);
        model.addAttribute("info", request);
        citiesController.incrementStats();
        return "madrid";
    }

    //Valencia
    @RequestMapping(method = RequestMethod.GET, value = "/valencia")
    String mapa1(Model model) throws JsonProcessingException {
        Cities request = citiesController.citiesByIdx((long) 6637);
        model.addAttribute("info", request);
        citiesController.incrementStats();
        return "valencia";
    }

    //Vigo
    @RequestMapping(method = RequestMethod.GET, value = "/vigo")
    String mapa2(Model model) throws JsonProcessingException {
        Cities request = citiesController.citiesByIdx((long) 10027);
        model.addAttribute("info", request);
        citiesController.incrementStats();
        return "vigo";
    }

    //Valladolid
    @RequestMapping(method = RequestMethod.GET, value = "/valladolid")
    String mapa3(Model model) throws JsonProcessingException {
        Cities request = citiesController.citiesByIdx((long) 11812);
        model.addAttribute("info", request);
        citiesController.incrementStats();
        return "valladolid";
    }

    //Bilbao
    @RequestMapping(method = RequestMethod.GET, value = "/bilbao")
    String mapa4(Model model) throws JsonProcessingException {
        Cities request = citiesController.citiesByIdx((long) 6732);
        model.addAttribute("info", request);
        citiesController.incrementStats();
        return "bilbao";
    }

    //Corunha
    @RequestMapping(method = RequestMethod.GET, value = "/corunha")
    String mapa5(Model model) throws JsonProcessingException {
        Cities request = citiesController.citiesByIdx((long) 5754);
        model.addAttribute("info", request);
        citiesController.incrementStats();
        return "corunha";
    }

}
