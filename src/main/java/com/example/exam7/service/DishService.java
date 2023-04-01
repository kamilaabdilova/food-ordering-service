package com.example.exam7.service;

import com.example.exam7.dao.DishDao;
import com.example.exam7.dto.DishDto;
import com.example.exam7.entity.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DishService {
    private final DishDao dishDao;

    public static DishDto makeDishDto(Dish dish) {
        DishDto dishDto = new DishDto();
        dishDto.setIdDish(dish.getIdDish());
        dishDto.setName(dish.getName());
        dishDto.setType(dish.getType());
        dishDto.setPrice(dish.getPrice());
        return dishDto;
    }

    public List<DishDto> showAllDishesByEstablishmentId(Long idEstablishment) {
        return dishDao.getDishes(idEstablishment);
    }}
