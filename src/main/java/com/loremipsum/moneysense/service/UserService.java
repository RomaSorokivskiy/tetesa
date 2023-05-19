package com.loremipsum.moneysense.service;

import com.loremipsum.moneysense.entity.UserEntity;
import com.loremipsum.moneysense.pojo.UserModel;
import com.loremipsum.moneysense.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public UserModel getOne(String email){
        UserEntity user = repository.findByEmail(email)
                .orElseThrow(() ->new UsernameNotFoundException("user not found"));
        return UserModel.toModel(user);
    }

    public UserModel getOne(Long id) {
        UserEntity user = repository.findById(id)
                .orElseThrow(() ->new UsernameNotFoundException("user not found"));
        return UserModel.toModel(user);
    }
}
