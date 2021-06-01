package com.co.portafolio.superMarket.controller;

import com.co.portafolio.superMarket.service.IProductService;
import com.co.portafolio.superMarket.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(iProductService.findAll());
    }

    @GetMapping("/id/{ProductId}")
    public ResponseEntity<?> finadById(@PathVariable Integer productId){
        return ResponseEntity.ok(iProductService.findById(productId));
    }

    @GetMapping("/code/{codeBar}")
    public ResponseEntity<?> finbByBarCode(@PathVariable Integer barCode){
        return ResponseEntity.ok(iProductService.findByBarCode(barCode));
    }

    @PostMapping()
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto){
            try {
                iProductService.createProduct(productDto);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (Exception exception){
                return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
            }
    }

    @PutMapping("/updateProdcuct/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer productId, @RequestBody ProductDto productDto){
        try{
            return new ResponseEntity(iProductService.updateProduct(productId,productDto), HttpStatus.OK);
        }catch ( Exception exception){
            return new ResponseEntity<>(exception.getCause(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<?> deleteProduct (@PathVariable Integer productId) {
        try{
            iProductService.deleteProduct(productId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception exception) {
            return new ResponseEntity<>(exception.getCause(), HttpStatus.BAD_REQUEST);
        }
    }
}