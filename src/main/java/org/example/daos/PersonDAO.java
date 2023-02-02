package org.example.daos;

import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getPersonList() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person getPersonById(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    public Optional<Person> getPersonByFullname(String fullname) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE fullname=?", new Object[]{fullname},
                new BeanPropertyRowMapper<>(Person.class))
                .stream()
                .findAny();
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(fullname, birthday) VALUES(?, ?)",
                person.getFullname(), person.getBirthday());
    }

    public void update(int id, Person person) {
        jdbcTemplate.update("UPDATE Person SET fullname=?, birthday=? WHERE id=?", person.getFullname(),
                person.getBirthday(), id);
    }
}
