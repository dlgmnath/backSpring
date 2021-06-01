package com.co.portafolio.superMarket.controller;

import com.co.portafolio.superMarket.dto.EmployDto;
import com.co.portafolio.superMarket.service.IEmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employ")
public class EmployController {

    @Autowired
    IEmployService iEmployService;

    @GetMapping()
    public ResponseEntity<?> finaAll(){
        return ResponseEntity.ok(iEmployService.findAll());
    }

    @GetMapping("/id/{ProductId}")
    public ResponseEntity<?> finadById(@PathVariable Integer employId){
        return ResponseEntity.ok(iEmployService.findById(employId));
    }

    @GetMapping("/code/{codeBar}")
    public ResponseEntity<?> finbByBarCode(@PathVariable String name){
        return ResponseEntity.ok(iEmployService.findByName(name));
    }

    @PostMapping()
    public ResponseEntity<?> createProduct(@RequestBody EmployDto employDto){
        try {
            iEmployService.createEmploy(employDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateProdcuct/{productId}")
    public ResponseEntity<?> updateEmploy(@PathVariable Integer employId, @RequestBody EmployDto employDto){
        try{
            return new ResponseEntity(iEmployService.updateEmploy(employId,employDto), HttpStatus.OK);
        }catch ( Exception exception){
            return new ResponseEntity<>(exception.getCause(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<?> deleteEmploy (@PathVariable Integer updateEmploy) {
        try{
            iEmployService.deleteEmploy(updateEmploy);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception exception) {
            return new ResponseEntity<>(exception.getCause(), HttpStatus.BAD_REQUEST);
        }
    }
}
