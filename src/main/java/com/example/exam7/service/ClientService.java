package com.example.exam7.service;

import com.example.exam7.dao.ClientDao;
import com.example.exam7.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientDao clientDao;

    public String registr(Client client) {
        try {
            clientDao.registr(client);
            return "ok";
        } catch (Exception e) {
            return e.getMessage();
        }

    }
    public Client findByEmail(String email){
        return clientDao.findByEmail(email);
    }
}

