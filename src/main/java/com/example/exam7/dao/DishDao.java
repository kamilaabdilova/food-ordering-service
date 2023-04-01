package com.example.exam7.dao;

import com.example.exam7.dto.DishDto;
import com.example.exam7.entity.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DishDao {
    private final JdbcTemplate jdbcTemplate;

    public List<DishDto> getDishes(Long idEstablishment) {
        String query = "select id, name, type, price from dish where id_establishment = ? ;";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(DishDto.class), idEstablishment);
    }
}
