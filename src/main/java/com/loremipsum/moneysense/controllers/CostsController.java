package com.loremipsum.moneysense.controllers;

import com.loremipsum.moneysense.entity.CostsEntity;
import com.loremipsum.moneysense.service.CostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/costs")
public class CostsController {

@Autowired
private CostsService service;


@PostMapping
public ResponseEntity addCosts(@RequestBody CostsEntity costs,
                               @RequestParam Long user_id){
    return ResponseEntity.ok(service.addCosts(costs, user_id));
}

@DeleteMapping
public ResponseEntity deleteCosts(@RequestParam Long id){
    service.deleteCosts(id);
    return new ResponseEntity<>(id, HttpStatus.OK);
}

@PutMapping
public ResponseEntity updateCosts(@RequestBody CostsEntity costs,
                                  @RequestParam Long id){
    return ResponseEntity.ok(service.updateCosts(costs, id));
}


//@PutMapping
}
