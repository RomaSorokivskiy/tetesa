package com.loremipsum.moneysense.service;

import com.loremipsum.moneysense.entity.CostsEntity;
import com.loremipsum.moneysense.entity.UserEntity;
import com.loremipsum.moneysense.pojo.CostsModel;
import com.loremipsum.moneysense.repository.CostsRepository;
import com.loremipsum.moneysense.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class CostsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CostsRepository costsRepository;
    public CostsModel addCosts(CostsEntity costs, Long userId) {
        costs.setCreatedAt(Date.valueOf(LocalDate.now(ZoneId.of("GMT+0300"))));
        UserEntity user = userRepository.findById(userId).
                orElseThrow(() ->new UsernameNotFoundException("user not found"));
        costs.setOwner(user);
        return CostsModel.toModel(costsRepository.save(costs));
    }

    public void deleteCosts(Long id) {
        costsRepository.deleteById(id);
    }

    public CostsModel updateCosts(CostsEntity costs, Long id) {
        CostsEntity findEntity = costsRepository.findById(id)
                .orElseThrow(() ->new UsernameNotFoundException("costs not found"));
        if (costs.getValue() != 0)
            findEntity.setValue(costs.getValue());
        if (costs.getCategory() != null)
            findEntity.setCategory(costs.getCategory());
        if (costs.getColor() != null)
            findEntity.setColor(costs.getColor());

        findEntity.setUpdatedAt(Date.valueOf(LocalDate.now(ZoneId.of("GMT+0300"))));
        costsRepository.save(findEntity);
        return CostsModel.toModel(findEntity);
    }
}
