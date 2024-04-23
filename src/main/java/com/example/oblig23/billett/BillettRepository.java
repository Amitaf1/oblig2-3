package com.example.oblig23.billett;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BillettRepository {

    private List<Billett> billetter = new ArrayList<>();

    List<Billett> findAll() {
        return billetter;
    }


    Optional<Billett> findById(Integer id) {
        return billetter.stream()
                .filter(billett -> billett.getId() == id)
                .findFirst();
    }

    void create(Billett billett) {
        billetter.add(billett);
    }

    @PostConstruct
    private void init() {
        billetter.add(new Billett(2,
                "Spider-Man", 3,
                "Yusuf", "Ali",
                12345678, "b@b.com"));

        billetter.add(new Billett(3,
                "Mean Girls", 4,
                "Sara", "Ali",
                87654321, "s@s.com"));
    }

}
