package com.example.exam7.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DishDto {
    private Long idDish;
    private String name;
    private String type;
    private Long idEstablishment;
    private Integer price;

}
