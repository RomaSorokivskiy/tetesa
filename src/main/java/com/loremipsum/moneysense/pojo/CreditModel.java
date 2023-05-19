package com.loremipsum.moneysense.pojo;

import com.loremipsum.moneysense.entity.CreditEntity;
import lombok.Data;

import java.util.Date;

@Data
public class CreditModel {
    private Long id;
    private double receivedCash;
    private double refundCash;
    private Date openAt;
    private Date updateAt;
    private Date closed;
    private double rate;

    public static CreditModel toModel(CreditEntity entity){
        CreditModel model = new CreditModel();
        model.setId(entity.getId());
        model.setReceivedCash(entity.getReceivedCash());
        model.setRefundCash(entity.getRefundCash());
        model.setOpenAt(entity.getOpenAt());
        model.setOpenAt(entity.getOpenAt());
        model.setClosed(entity.getClosed());
        model.setRate(entity.getRate());
        return model;
    }
}
