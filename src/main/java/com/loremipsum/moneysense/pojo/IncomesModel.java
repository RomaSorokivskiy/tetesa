package com.loremipsum.moneysense.pojo;

import com.loremipsum.moneysense.entity.IncomeEntity;
import lombok.Data;

import java.util.Date;

@Data
public class IncomesModel {
    private Long id;
    private double value;
    private Date data;
    private Date updatedAt;

    public static IncomesModel toModel(IncomeEntity entity){
        IncomesModel incomesModel = new IncomesModel();
        incomesModel.setId(entity.getId());
        incomesModel.setValue(entity.getValue());
        incomesModel.setData(entity.getDate());
        incomesModel.setUpdatedAt(entity.getUpdatedAt());
        return incomesModel;
    }
}
