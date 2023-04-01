package com.example.exam7.entity;

import lombok.*;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class Order {
    private Long idOrder;
    private Client client;
    private Dish dish;
    private LocalDateTime dateOrder;

}
