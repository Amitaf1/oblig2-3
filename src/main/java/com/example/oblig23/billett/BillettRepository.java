package com.example.oblig23.billett;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class BillettRepository {

    private static final Logger log = LoggerFactory.getLogger(BillettRepository.class);

    private final JdbcClient jdbcClient;

    @Autowired
    public BillettRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Billett> findAll() {
        return jdbcClient.sql("SELECT * FROM BILLETT")
                .query(Billett.class)
                .list();
    }

    public Optional<Billett> findById(Integer id) {
        return jdbcClient.sql("SELECT id, film, amount, fname, lname, telnr, email FROM BILLETT WHERE id = :id")
                .param("id", id)
                .query(Billett.class)
                .optional();
    }

    public void create(Billett billett) {
        Objects.requireNonNull(billett.getId(), "ID must not be null");
        Objects.requireNonNull(billett.getFilm(), "Film must not be null");
        Objects.requireNonNull(billett.getAmount(), "Amount must not be null");
        Objects.requireNonNull(billett.getFname(), "First name must not be null");
        Objects.requireNonNull(billett.getLname(), "Last name must not be null");
        Objects.requireNonNull(billett.getTelnr(), "Telephone number must not be null");
        Objects.requireNonNull(billett.getEmail(), "Email must not be null");


        var updated = jdbcClient.sql("INSERT INTO BILLETT(film, amount, fname, lname, telnr, email) VALUES(?, ?, ?, ?, ?, ?)")
                .params(billett.getFilm(), billett.getAmount(), billett.getFname(), billett.getLname(), billett.getTelnr(), billett.getEmail())
                .update();
        Assert.state(updated == 1, "Failed to insert ticket");
    }

    public void update(Billett billett, Integer id) {
        var updated = jdbcClient.sql("UPDATE BILLETT SET film = ?, amount = ?, fname = ?, lname = ?, telnr = ?, email = ? WHERE id = ?")
                .params(billett.getFilm(), billett.getAmount(), billett.getFname(), billett.getLname(), billett.getTelnr(), billett.getEmail(), id)
                .update();
        Assert.state(updated == 1, "Failed to update ticket with id: " + id);
    }

    public void delete(Integer id) {
        var updated = jdbcClient.sql("DELETE FROM BILLETT WHERE id = ?")
                .params(id)
                .update();
        Assert.state(updated == 1, "Failed to delete ticket with id: " + id);
    }

    public int count() {
        List<Integer> result = jdbcClient.sql("SELECT COUNT(*) FROM BILLETT")
                .query((resultSet, i) -> resultSet.getInt(1))  // Extract the integer value from the first column
                .list();  // Retrieve the list of integer results

        if (result.isEmpty()) {
            throw new RuntimeException("No count result found");
        }

        return result.get(0);  // Retrieve the first (and only) integer result
    }



    public void saveAll(List<Billett> billetter) {
        billetter.forEach(this::create);
    }
}
