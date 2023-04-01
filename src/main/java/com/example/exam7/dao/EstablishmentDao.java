package com.example.exam7.dao;

import com.example.exam7.entity.Establishment;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EstablishmentDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Establishment> getAll() {
        String sql = "select * from establishment";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Establishment.class));
    }
}
