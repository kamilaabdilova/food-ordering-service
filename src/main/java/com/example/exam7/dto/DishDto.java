package com.example.exam7.dto;

import com.example.exam7.entity.Dish;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.security.web.access.intercept.RequestMatcherDelegatingAuthorizationManager.builder;

@Data
@NoArgsConstructor
public class DishDto {

    private Long idDish;
    private String name;
    private String type;
    private Long idEstablishment;
    private Integer price;

}
