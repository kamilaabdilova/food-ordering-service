package com.example.exam7.controller;

import com.example.exam7.dto.OrderDto;
import com.example.exam7.service.ClientService;
import com.example.exam7.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private final ClientService clientService;
    public final OrderService orderService;

    @PostMapping("/addOrder{idDish}")
    public ResponseEntity<String> addOrder(@RequestParam Long idDish, Authentication authentication) {
        String email = authentication.getName();
        Long idClient = clientService.findByEmail(email).getIdClient();
        return new ResponseEntity<>(orderService.addOrder(idClient, idDish), HttpStatus.OK);
    }

    @GetMapping("/my")
    public ResponseEntity<List<OrderDto>> getMyOrders(Authentication authentication) {
        String email = authentication.getName();
        long myId = clientService.findByEmail(email).getIdClient();
        return new ResponseEntity<>(orderService.getMyOrders(myId), HttpStatus.OK);
    }
}
