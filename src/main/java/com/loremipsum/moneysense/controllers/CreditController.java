package com.loremipsum.moneysense.controllers;

import com.loremipsum.moneysense.entity.CreditEntity;
import com.loremipsum.moneysense.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/credit")
public class CreditController {
    @Autowired
    private CreditService service;

    @PostMapping
    public ResponseEntity addCredit(@RequestBody CreditEntity entity,
                                     @RequestParam Long user_id){
        return ResponseEntity.ok(service.addCredit(entity, user_id));
    }

    @DeleteMapping
    public ResponseEntity deleteCredit(@RequestParam Long id){
        service.deleteCredit(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity editCredit(@RequestBody CreditEntity entity,
                                      @RequestParam Long id){
        return ResponseEntity.ok(service.editCredit(entity, id));
    }


}
