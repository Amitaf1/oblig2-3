package com.example.oblig23.billett;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Billett, Integer> {
    // You can add custom query methods here if needed
}
