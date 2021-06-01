package com.co.portafolio.superMarket.controller;

import com.co.portafolio.superMarket.dto.PositionDto;
import com.co.portafolio.superMarket.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    IPositionService iPositionService;

    @GetMapping()
    public ResponseEntity<?> findAl() {
        return ResponseEntity.ok(iPositionService.findAll());
    }

    @GetMapping("/id/{positionId}")
    public ResponseEntity<?> findById(@PathVariable Integer positionId) {
        return ResponseEntity.ok(iPositionService.findById(positionId));
    }

    @GetMapping("/position/{position}")
    public ResponseEntity<?> findByPosition(@PathVariable String position) {
        return ResponseEntity.ok(iPositionService.findByPosition(position));
    }

    @PostMapping()
    public ResponseEntity<?> CreatePosition(@RequestBody PositionDto positionDto){
        try{
            iPositionService.createPosition(positionDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
