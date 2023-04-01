package com.example.exam7.entity;

import com.example.exam7.utils.GenerateData;
import lombok.*;

import static org.springframework.security.web.access.intercept.RequestMatcherDelegatingAuthorizationManager.builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Long idClient;
    private String name;
    private String email;
    private String password;
    private Boolean enabled = Boolean.TRUE;
//    public static Client random() {
//        return builder()
//                .name(GenerateData.randomPersonName())
//                .email(GenerateData.randomEmail())
//                .build();
//    }
}
