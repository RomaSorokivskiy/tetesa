package com.loremipsum.moneysense.pojo;

import com.loremipsum.moneysense.entity.CostsEntity;
import lombok.Data;

import java.util.Date;

@Data
public class CostsModel {
    private Long id;
    private String color;
    private String category;
    private double value;
    private Date createdAt;
    private Date updatedAt;

    public static CostsModel toModel(CostsEntity entity){
        CostsModel model = new CostsModel();
        model.setId(entity.getId());
        model.setColor(entity.getColor());
        model.setValue(entity.getValue());
        model.setCategory(entity.getCategory());
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }
}
