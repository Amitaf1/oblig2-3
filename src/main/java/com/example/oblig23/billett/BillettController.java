package com.example.oblig23.billett;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/billetter")
public class BillettController {

    private final BillettRepository billettRepository;

    public BillettController(BillettRepository billettRepository) {
        this.billettRepository = billettRepository;
    }
    @GetMapping("")
    List<Billett> findAll() {
       return billettRepository.findAll();
   }

    @GetMapping("/{id}")
    Billett findBiId(@PathVariable Integer id) {
        Optional<Billett> billett = billettRepository.findById(id);
        if (billett.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return billett.get();
    }


    // post
    void create (@RequestBody Billett billett) {
        billettRepository.create(billett);
    }


    // put


    // delete

}
