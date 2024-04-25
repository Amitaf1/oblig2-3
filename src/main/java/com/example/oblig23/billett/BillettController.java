package com.example.oblig23.billett;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/billetter")
public class BillettController {

    private final BillettService billettService;

    @Autowired
    public BillettController(BillettService billettService) {
        this.billettService = billettService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Billett>> getAllBilletter() {
        List<Billett> billetList = billettService.getAllBilletter(); // Use billetList
        return ResponseEntity.ok(billetList);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createBillett(@Valid @RequestBody BillettRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        Billett savedBillett = billettService.createBillett(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBillett);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Billett> updateBillett(@PathVariable Integer id, @RequestBody BillettRequest request) {
        Billett updatedBillett = billettService.updateBillett(id, request);
        return ResponseEntity.ok(updatedBillett);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Billett> getBillettById(@PathVariable Integer id) {
        Billett billett = billettService.getBillettById(id);
        return ResponseEntity.ok(billett);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> slettAlleBilletter() {
        billettService.slettAlleBilletter();
        return ResponseEntity.noContent().build();
    }
}
