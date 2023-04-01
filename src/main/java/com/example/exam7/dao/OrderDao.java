package com.example.exam7.dao;

import com.example.exam7.entity.Order;
import com.example.exam7.service.OrderRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Order> getMyOrders(long myId) {
        String query = "select * from order o \n" +
                "inner join client c on o.id_client = c.id \n" +
                "inner join dish d on o.id_dish = d.id \n" +
                "inner join establishment r on d.id_establishment = r.id \n" +
                "where o.id_client = ? ;";
        return jdbcTemplate.query(query, new OrderRowMapper(), myId);
    }

    public void addOrder(long clientId, long dishId) throws SQLException {
        String query = "INSERT INTO order (id_client, id_dish, date_order)\n" +
                "    VALUES( ?, ?, ?); \n";
        int update = jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setLong(1, clientId);
            ps.setLong(2, dishId);
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            return ps;
        });
        if (update == 0) {
            throw new SQLException();
        }
    }
}
