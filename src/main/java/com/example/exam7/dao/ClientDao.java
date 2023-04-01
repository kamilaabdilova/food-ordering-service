package com.example.exam7.dao;

import com.example.exam7.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class ClientDao {
    private final JdbcTemplate jdbcTemplate;

    private final PasswordEncoder encoder;

    public void save(Client client) {
        String sql = "insert into clients(id, name, email, password) " +
                "values(?,?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, client.getIdClient());
            ps.setString(2, client.getName());
            ps.setString(3, client.getEmail());
            ps.setString(4, this.encoder.encode(client.getPassword()));

            return ps;
        });
    }

    public void registr(Client client) throws SQLException {
        String query = "INSERT INTO clients (name, email, password)\n" +
                "    VALUES( ?, ?, ?);\n";
        int update = jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setString(3, encoder.encode(client.getPassword()));
            return ps;
        });
        if (update == 0) {
            throw new SQLException();
        }
        addAuth(client.getEmail());
    }

    public void addAuth(String email) throws SQLException {
        String query = "INSERT INTO authorities (username, authority)\n" +
                "    VALUES( ?, ?); \n";
        int update = jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, "ROLE_CLIENT");
            return ps;
        });
        if (update == 0) {
            throw new SQLException();
        }
    }

    public Client findByEmail(String email) {
        String query = "select * from clients where email = ? ;";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Client.class), email);
    }

}
