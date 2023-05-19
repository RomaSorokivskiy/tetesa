package com.loremipsum.moneysense.pojo;

import com.loremipsum.moneysense.entity.UserEntity;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<IncomesModel> incomes;
    private List<CostsModel> costs;
    private List<DepositModel> deposits;
    private List<CreditModel> credits;

    public static UserModel toModel(UserEntity entity){
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setEmail(entity.getEmail());
        model.setIncomes(entity.getIncomes().stream().map(IncomesModel::toModel).collect(Collectors.toList()));
        model.setCosts(entity.getCosts().stream().map(CostsModel::toModel).collect(Collectors.toList()));
        model.setDeposits(entity.getDeposits().stream().map(DepositModel::toModel).collect(Collectors.toList()));
        model.setCredits(entity.getCredits().stream().map(CreditModel::toModel).collect(Collectors.toList()));
        return model;
    }
}
