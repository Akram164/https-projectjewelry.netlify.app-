package com.myorganisation.eurekaservice1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client/eurekaserice2")
public class EurekaService2Client {

    @Autowired
    private EurekaService2Client eurekaService2Client;


    @GetMapping
    ResponseEntity<String> es2ServerStatus(){
        return eurekaService2Client.es2ServerStatus();

    }
    @GetMapping("/api")
    ResponseEntity<String> es2ApiStatus(){
        return eurekaService2Client.es2ApiStatus();
    }


}
