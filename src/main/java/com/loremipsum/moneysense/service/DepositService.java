package com.loremipsum.moneysense.service;

import com.loremipsum.moneysense.entity.DepositEntity;
import com.loremipsum.moneysense.entity.UserEntity;
import com.loremipsum.moneysense.pojo.DepositModel;
import com.loremipsum.moneysense.repository.DepositRepository;
import com.loremipsum.moneysense.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class DepositService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepositRepository depositRepository;


    public DepositModel addDeposit(DepositEntity entity, Long userId) {
        entity.setOpenAt(Date.valueOf(LocalDate.now(ZoneId.of("GMT+0300"))));
        UserEntity user = userRepository.findById(userId).orElseThrow(); // todo throw
        entity.setOwner(user);
        depositRepository.save(entity);
        return DepositModel.toModel(entity);
    }

    public void deleteDeposit(Long id) {
        depositRepository.deleteById(id);
    }

    public DepositModel editDeposit(DepositEntity entity, Long id) {
        DepositEntity findEntity = depositRepository.findById(id).orElseThrow();
        if (entity.getEnteredCash() != 0)
            findEntity.setEnteredCash(entity.getEnteredCash());
        if (entity.getRate() != 0)
            findEntity.setRate(entity.getRate());
        findEntity.setUpdatedAt(Date.valueOf(LocalDate.now(ZoneId.of("GMT+0300"))));
        depositRepository.save(findEntity);
        return DepositModel.toModel(findEntity);
    }
}
