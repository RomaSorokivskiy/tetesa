package com.loremipsum.moneysense.repository;

import com.loremipsum.moneysense.entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<CreditEntity, Long> {
}
