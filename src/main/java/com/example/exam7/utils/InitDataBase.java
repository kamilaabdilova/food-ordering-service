package com.example.exam7.utils;

import com.example.exam7.dao.ClientDao;
import com.example.exam7.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

@Configuration
@RequiredArgsConstructor
public class InitDataBase {
    private final JdbcTemplate jdbcTemplate;
    private final ClientDao clientDao;
    @Bean
    public CommandLineRunner init() throws SQLException {

        return (args -> {
            createClientTable();

            Client client = new Client();
            client.setIdClient(1);
            client.setName("Kamila");
            client.setEmail("kamila@gmail.com");
            client.setPassword("kamila25");
            clientDao.save(client);

            Client client1 = new Client();
            client1.setIdClient(2);
            client1.setName("Max");
            client1.setEmail("max@gmail.com");
            client1.setPassword("max11");
            clientDao.save(client1);

        });
    }
    public void createClientTable() {
        String tableClient = "create table if not exists clients\n" +
                "(\n" +
                "id serial not null primary key,\n" +
                "name varchar, \n" +
                "email varchar \n" +
                ");\n";

        jdbcTemplate.execute(tableClient);

    }
}
