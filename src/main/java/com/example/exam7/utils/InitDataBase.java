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
            client.setIdClient(1L);
            client.setName("Kamila");
            client.setEmail("kamila@gmail.com");
            client.setPassword("kamila25");
            clientDao.save(client);

            Client client1 = new Client();
            client1.setIdClient(2L);
            client1.setName("Max");
            client1.setEmail("max@gmail.com");
            client1.setPassword("max11");
            clientDao.save(client1);


            createDishTable();
            createEstablishmentTable();
            createOrderTable();
            createAuthTable();
        });
    }
    public void createClientTable() {
        String tableClient = "create table if not exists clients\n" +
                "(\n" +
                "id serial not null primary key,\n" +
                "name varchar, \n" +
                "email varchar unique, \n" +
                "password varchar \n" +
                ");\n";

        jdbcTemplate.execute(tableClient);

    }
    public void createDishTable() {
        String tableDish = "create table if not exists dish\n" +
                "(\n" +
                "id serial not null primary key,\n" +
                "name varchar, \n" +
                "type varchar, \n" +
                "price integer \n" +
                ");\n";
        String dish = "insert into dish(name, type, price)" +
                "values ('Lagman', 'national food', 300)," +
                "('Aperol', 'Cocktails', 500)," +
                "('Tom-yam', 'Soup', 600)," +
                "('Baskin Robbins', 'Ice cream', 200)," +
                "('Napoleon', 'dessert', 400)";
        jdbcTemplate.execute(tableDish);
        jdbcTemplate.execute(dish);
    }
    public void createEstablishmentTable() {
        String tableEstablishment = "create table if not exists establishment\n" +
                "(\n" +
                "id serial not null primary key,\n" +
                "name varchar, \n" +
                "description varchar \n" +
                ");\n";
        String esta = "insert into establishment(name, description)" +
                "values ('Navat', 'national food with meat and vegetables')," +
                "('Live Bar', 'Alcohol cocktails')," +
                "('Social-Coffee', 'China soup')," +
                "('Bishkek Park', 'Strawberry Ice cream')," +
                "('Moqa', 'tasty dessert')";

        jdbcTemplate.execute(tableEstablishment);
        jdbcTemplate.execute(esta);
    }
    public void createOrderTable() {
        String tableOrder = "create table if not exists orders\n" +
                "(\n" +
                "id serial not null primary key,\n" +
                "id_client integer, \n" +
                "id_dish integer, \n" +
                "date_order timestamp \n" +
                ");\n";
        String order = "insert into orders(id_client, id_dish, date_order)" +
                "values ( 1, 2, date(now()))," +
                "(2, 3, date(now()))," +
                "(1, 1, date(now()))," +
                "(2, 3, date(now()))," +
                "(1, 2, date(now()))," +
                "(2, 2, date(now()))";
        jdbcTemplate.execute(tableOrder);
        jdbcTemplate.execute(order);
    }
    public void createAuthTable(){
        String tableAuth = "CREATE TABLE authorities\n" +
                "(\n" +
                "    name  varchar   NOT NULL primary key\n" +
                "        constraint authorities_clients___fk REFERENCES clients (email)\n" +
                "        ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "    authority varchar(50)    NOT NULL\n" +
                ");\n";
        String auth = "insert into authorities(name, authority)" +
                "values ('kamila@gmail.com', true)," +
                "('max@gmail.com', true)";
        jdbcTemplate.execute(tableAuth);
        jdbcTemplate.execute(auth);
    }

}
