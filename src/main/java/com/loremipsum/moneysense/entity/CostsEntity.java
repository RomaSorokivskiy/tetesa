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
public class CostsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double value;
    private String category;
    private String color;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity owner;
    private Date createdAt;
    private Date updatedAt;


}
