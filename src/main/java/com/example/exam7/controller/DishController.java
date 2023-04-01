package com.example.exam7.controller;

import com.example.exam7.dto.DishDto;
import com.example.exam7.service.DishService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("/dishes")
public class DishController {
    public final DishService dishService;

    @GetMapping("/weCanSeeAllDishesByEstablishment{idEstablishment}")
    public ResponseEntity<DishDto> showAllDishByEstablishmentId(@RequestParam Long idEstablishment){
        return new ResponseEntity<>(dishService.showAllDishesByEstablishmentId(idEstablishment), HttpStatus.OK);
    }
}
