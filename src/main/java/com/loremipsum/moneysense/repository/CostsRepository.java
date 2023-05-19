package com.loremipsum.moneysense.repository;

import com.loremipsum.moneysense.entity.CostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostsRepository extends JpaRepository<CostsEntity, Long> {
}
