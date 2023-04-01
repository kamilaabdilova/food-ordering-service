package com.example.exam7.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Long idClient;
     private Long idDish;
    private LocalDateTime dateOrder;
}
