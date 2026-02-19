package com.myorganisation.eurekaservice2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client/eurekaservice1")
public class EurekaserviceController {

    @Autowired
    private EurekaserviceController eurekaserviceController;

    @GetMapping
    ResponseEntity<String> es1ServerStatus(){
        return eurekaserviceController.es1ServerStatus();
    }

    @GetMapping("/api")
    ResponseEntity<String> es1ApiStatus(){
        return eurekaserviceController.es1ApiStatus();
    }
}
