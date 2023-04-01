package com.example.exam7.controller;

import com.example.exam7.dto.OrderDto;
import com.example.exam7.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OrdersController {
    public final OrderService orderService;

    @PostMapping("/addOrder")
    public ResponseEntity<String> addOrder(@RequestParam Long idClient, Long idDish) {
        return new ResponseEntity<>(orderService.addOrder(idClient, idDish), HttpStatus.OK);
    }
}