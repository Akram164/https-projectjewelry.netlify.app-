package com.myorganisation.eurekaservice2.controller;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Servercontroller {
    @GetMapping
    public ResponseEntity<String> serverStatus(){
        return new ResponseEntity<>("EurekaService-2 is live", HttpStatusCode.valueOf(200));
    }

    @GetMapping("/api")
    public ResponseEntity<String> serverApiStatus(){
        return new ResponseEntity<>("EurekaService-2 API is live",HttpStatusCode.valueOf(200));
    }

}
