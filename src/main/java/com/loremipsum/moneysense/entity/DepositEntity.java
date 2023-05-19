package com.loremipsum.moneysense.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DepositEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double enteredCash;
    private double expectedCash;
    private Date openAt;
    private Date updatedAt;
    private Date closed;
    private double rate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity owner;
}
