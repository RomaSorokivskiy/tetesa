package com.loremipsum.moneysense.pojo;

import com.loremipsum.moneysense.entity.DepositEntity;
import lombok.Data;

import java.util.Date;

@Data
public class DepositModel {
    private Long id;
    private double enteredCash;
    private double expectedCash;
    private Date openAt;
    private Date updatedAt;
    private Date closed;
    private double rate;

    public static DepositModel toModel(DepositEntity entity){
        DepositModel model = new DepositModel();
        model.setId(entity.getId());
        model.setEnteredCash(entity.getEnteredCash());
        model.setExpectedCash(entity.getExpectedCash());
        model.setOpenAt(entity.getOpenAt());
        model.setClosed(entity.getClosed());
        model.setUpdatedAt(entity.getUpdatedAt());
        model.setRate(entity.getRate());
        return model;
    }
}
