package com.example.exam7.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Order {
    private Long idOrder;
    private Client client;
    private Dish dish;
    private LocalDateTime dateOrder;

}
