package com.example.exam7.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Dish {
    private Long idDish;
    private String name;
    private String type;
    private Integer price;
}
