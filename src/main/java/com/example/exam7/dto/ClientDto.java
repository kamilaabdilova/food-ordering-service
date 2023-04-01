package com.example.exam7.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientDto {
    private Long idClient;
    private String name;
    private String email;
}

