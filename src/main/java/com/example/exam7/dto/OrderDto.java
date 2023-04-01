package com.example.exam7.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Data
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String Client;
     private DishDto dish;
    private LocalDateTime dateOrder;
}
