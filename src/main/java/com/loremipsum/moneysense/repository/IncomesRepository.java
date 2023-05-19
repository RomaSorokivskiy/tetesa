package com.loremipsum.moneysense.repository;

import com.loremipsum.moneysense.entity.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomesRepository extends JpaRepository<IncomeEntity, Long> {
}
