package com.example.loadbooking.controller;

import com.example.loadbooking.entity.Load;
import com.example.loadbooking.service.LoadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//LoadController 
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/loads")
public class LoadController {

    private final LoadService loadService;

    public LoadController(LoadService loadService) {
        this.loadService = loadService;
    }

    // Create a new Load
    @PostMapping("/createLoad")
    public ResponseEntity<Load> createLoad(@RequestBody Load load) {
        Load createdLoad = loadService.createLoad(load);
        return ResponseEntity.ok(createdLoad);
    }

    // Get all Loads
    @GetMapping("/getAllLoads")
    public ResponseEntity<List<Load>> getAllLoads() {
        List<Load> loads = loadService.getAllLoads();
        return ResponseEntity.ok(loads);
    }

    // Get Load by ID
    @GetMapping("getLoadbyId/{id}")
    public ResponseEntity<Load> getLoadById(@PathVariable UUID id) {
        Load load = loadService.getLoadById(id);
        return ResponseEntity.ok(load);
    }

    // Update Load
    @PutMapping("updateLoadByid/{id}")
    public ResponseEntity<Load> updateLoad(@PathVariable UUID id, @RequestBody Load updatedLoad) {
        Load load = loadService.updateLoad(id, updatedLoad);
        return ResponseEntity.ok(load);
    }

    // Delete Load
    @DeleteMapping("deleteLoadbyId/{id}")
    public ResponseEntity<Void> deleteLoad(@PathVariable UUID id) {
        loadService.deleteLoad(id);
        return ResponseEntity.noContent().build();
    }
}
