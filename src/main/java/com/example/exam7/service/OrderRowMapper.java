package com.example.exam7.service;

import com.example.exam7.entity.Client;
import com.example.exam7.entity.Dish;
import com.example.exam7.entity.Establishment;
import com.example.exam7.entity.Order;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setIdOrder(rs.getLong("id"));
        Client client = new Client();
        client.setIdClient(rs.getLong("client_id"));
        client.setName(rs.getString("name"));
        client.setEmail(rs.getString("email"));
        client.setEnabled(rs.getBoolean("enabled"));
        order.setClient(client);
        Dish dish = new Dish();
        dish.setIdDish(rs.getLong("dish_id"));
        dish.setName(rs.getString("name"));
        Establishment establishment = new Establishment();
        establishment.setIdEstablishment(rs.getLong("restaurant_id"));
        establishment.setName(rs.getString("name"));
        establishment.setDescription(rs.getString("description"));
        dish.setEstablishment(establishment);
        dish.setType(rs.getString("type"));
        dish.setPrice(rs.getInt("price"));
        order.setDish(dish);
        order.setDateOrder(rs.getTimestamp("date").toLocalDateTime());
        return order;
    }
}
