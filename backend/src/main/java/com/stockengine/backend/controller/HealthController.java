package com.stockengine.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
public class HealthController {

    @GetMapping("/")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Stock Engine Backend is running!");
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("{\"status\":\"UP\"}");
    }
}
