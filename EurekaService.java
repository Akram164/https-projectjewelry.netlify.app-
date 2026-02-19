package com.myorganisation.eurekaservice1.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class EurekaService {
    @FeignClient(name = "eurekaservice2")
    public interface EurekaService2Clientservice{

        @GetMapping
        ResponseEntity<String> es2ServiceStatus();

        @GetMapping("/api")
        ResponseEntity<String> es2ApiStatus();
    }
}
