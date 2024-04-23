package com.example.oblig23.billett;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
            throw new BillettNotFoundException();
        }
        return billett.get();
    }


    // post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create (@RequestBody Billett billett) {
        billettRepository.create(billett);
    }


    // put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update (@RequestBody Billett billett, @PathVariable Integer id) {
        billettRepository.update(billett, id);
    }

    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete (@PathVariable Integer id) {
        billettRepository.delete(id);
    }
}
