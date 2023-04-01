package com.example.exam7.controller;

import com.example.exam7.dto.DishDto;
import com.example.exam7.service.EstablishmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("/establishment")
public class EstablishmentController {
    private final EstablishmentService establishmentService;

    @GetMapping("/showAllEstablishments")
    public ResponseEntity<DishDto> showAllDishByEstablishments(@RequestParam Long idEstablishment){
        return new ResponseEntity<>(establishmentService.showAllDishByEstablishment(idEstablishment), HttpStatus.OK);
    }

}
