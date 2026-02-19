package com.myorganisation.eurekaservice2.Service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eurekaservice")
public interface EurekaService {
    @GetMapping
    ResponseEntity<String> es1serverStatus();

    @GetMapping("/api")
    ResponseEntity<String> es1ApiStatus();
}
