package com.loremipsum.moneysense.controllers;

import com.loremipsum.moneysense.pojo.UserModel;
import com.loremipsum.moneysense.repository.UserRepository;
import com.loremipsum.moneysense.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
@NoArgsConstructor
public class UserController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserService service;
    @GetMapping("/user/")
    public ResponseEntity getUser(@RequestParam String email){
        UserModel userModel = service.getOne(email);
        return ResponseEntity.ok(userModel);
    }
    @PostMapping("/test/")
    public void setTest(@RequestBody UserModel model){
        System.out.println(model.getEmail());
        System.out.println(model.getFirstName());
        System.out.println(model.getLastName());
        System.out.println(model.getIncomes());
    }
}
