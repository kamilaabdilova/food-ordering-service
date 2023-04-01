package com.example.exam7.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Client {
    private Long idClient;
    private String name;
    private String email;
    private String password;
}
