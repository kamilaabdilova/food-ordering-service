package com.example.exam7.dao;

import com.example.exam7.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
@Component
@RequiredArgsConstructor
public class ClientDao {
    private final JdbcTemplate jdbcTemplate;

    private final PasswordEncoder encoder;
    public void save(Client client) {
        String sql = "insert into clients(id_client, name, email, password) " +
                "values(?,?,?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, client.getIdClient());
            ps.setString(2, client.getName());
            ps.setString(3, client.getEmail());
            ps.setString(5,this.encoder.encode(client.getPassword()));

            return ps;
        });
    }
}
