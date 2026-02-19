package com.myorganisation.apigateway.Controller;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ServerController {
    @GetMapping
    public ResponseEntity<String> apiGatewayStatus() {
        return new ResponseEntity<>("API Gateway is live!", HttpStatusCode.valueOf(200));
    }
}
