package com.example.exam7.controller;

import com.example.exam7.dto.ClientDto;
import com.example.exam7.dto.OrderDto;
import com.example.exam7.entity.Client;
import com.example.exam7.entity.Order;
import com.example.exam7.service.ClientService;
import com.example.exam7.service.OrderService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@AllArgsConstructor
@RestController
public class ClientController {
    private final ClientService clientService;
    public ResponseEntity<String> registr(@RequestBody Client client){
        return new ResponseEntity<>(clientService.registr(client), HttpStatus.OK);
    }


}
