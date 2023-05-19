package com.loremipsum.moneysense.repository;

import com.loremipsum.moneysense.entity.DepositEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<DepositEntity, Long> {
}
