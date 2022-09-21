package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value ="/distilleries/region")
    public ResponseEntity<List<Distillery>> getWhiskyByRegion(@RequestParam(name ="region") String region){
        return new ResponseEntity<>(distilleryRepository.findByRegionIgnoreCase(region), HttpStatus.OK);
    }

    @GetMapping(value = "distilleries/{id}/whiskies/")
    public ResponseEntity getWhiskyByDistilleryId (@PathVariable Long id){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryId(id), HttpStatus.OK);
    }

}
