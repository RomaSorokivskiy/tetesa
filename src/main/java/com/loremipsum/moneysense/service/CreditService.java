package com.loremipsum.moneysense.service;

import com.loremipsum.moneysense.entity.CreditEntity;
import com.loremipsum.moneysense.entity.UserEntity;
import com.loremipsum.moneysense.pojo.CreditModel;
import com.loremipsum.moneysense.repository.CreditRepository;
import com.loremipsum.moneysense.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private UserRepository userRepository;

    public CreditModel addCredit(CreditEntity entity, Long userId) {
        entity.setOpenAt(Date.valueOf(LocalDate.now(ZoneId.of("GMT+0300"))));
        UserEntity user = userRepository.findById(userId).orElseThrow();
        entity.setOwner(user);
        creditRepository.save(entity);
        return CreditModel.toModel(entity);
    }


    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }

    public Object editCredit(CreditEntity entity, Long id) {
        CreditEntity findEntity = creditRepository.findById(id).orElseThrow();
        if (entity.getReceivedCash() != 0)
            findEntity.setReceivedCash(entity.getReceivedCash());
        if (entity.getRate() != 0)
            findEntity.setRate(entity.getRate());
        findEntity.setUpdatedAt(Date.valueOf(LocalDate.now(ZoneId.of("GMT+0300"))));

        creditRepository.save(findEntity);
        return CreditModel.toModel(findEntity);
    }
}
