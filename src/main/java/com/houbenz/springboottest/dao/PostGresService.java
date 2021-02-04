package com.houbenz.springboottest.dao;

import com.houbenz.springboottest.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.List.of;

@Repository("postgres")
public class PostGresService implements PersonDAO {

    private final JdbcTemplate template;

    @Autowired
    public PostGresService(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPerson() {
        String sql ="select * from person";
       List<Person> persons= template.query(sql,(resultSet, i) -> {
            UUID id =UUID.fromString(resultSet.getString("id"));
            String name =resultSet.getString("name");
            return new Person(id, name);
        });

       return persons;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
