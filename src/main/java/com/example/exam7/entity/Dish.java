package com.example.exam7.entity;

import com.example.exam7.utils.GenerateData;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Dish {
    private Long idDish;
    private String name;
    private String type;
    private Integer price;
    private Establishment establishment;
//    public static Dish random() {
//        return builder()
//                .name(GenerateData.toDish())
//                .email(GenerateData.randomEmail())
//                .build();
//    }
}
