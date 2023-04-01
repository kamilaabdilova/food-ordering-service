package com.example.exam7.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EstablishmentDto {
    private Long idEstablishment;
    private String name;
    private String description;
}
