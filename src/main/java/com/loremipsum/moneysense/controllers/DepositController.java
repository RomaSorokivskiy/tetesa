package com.loremipsum.moneysense.controllers;

import com.loremipsum.moneysense.entity.DepositEntity;
import com.loremipsum.moneysense.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/deposit")
public class DepositController {

    @Autowired
    private DepositService service;

@PostMapping
public ResponseEntity addDeposit(@RequestBody DepositEntity entity,
                                 @RequestParam Long user_id){
    return ResponseEntity.ok(service.addDeposit(entity, user_id));
}

@DeleteMapping
public ResponseEntity deleteDeposit(@RequestParam Long id){
    service.deleteDeposit(id);
    return new ResponseEntity<>(id, HttpStatus.OK);
}

@PutMapping
public ResponseEntity editDeposit(@RequestBody DepositEntity entity,
                                  @RequestParam Long id){
    return ResponseEntity.ok(service.editDeposit(entity, id));
}



}
