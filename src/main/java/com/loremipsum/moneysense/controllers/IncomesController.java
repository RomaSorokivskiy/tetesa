package com.loremipsum.moneysense.controllers;

import com.loremipsum.moneysense.entity.IncomeEntity;
import com.loremipsum.moneysense.service.IncomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/icomes")
public class IncomesController {

    @Autowired
    private IncomesService service;
    @PostMapping
    public ResponseEntity addIncomes(@RequestBody IncomeEntity entity,
                                     @RequestParam Long userId){
        return ResponseEntity.ok(service.addIncomes(entity, userId));
    }

    @DeleteMapping
    public ResponseEntity<Long> deleteIncomes(@RequestParam Long id){
        service.deleteIncomes(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity updateValue(@RequestBody IncomeEntity entity,
                                      @RequestParam Long id){
        return ResponseEntity.ok(service.updateIncomes(entity, id));
    }

}
