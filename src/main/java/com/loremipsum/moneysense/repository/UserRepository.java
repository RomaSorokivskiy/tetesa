package com.loremipsum.moneysense.repository;

import com.loremipsum.moneysense.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    boolean existsUserEntityByEmail (String email);
}
