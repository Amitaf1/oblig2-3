package com.example.oblig23.billett;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Billett> createBillett(@RequestBody BillettRequest request) {
        Billett createdBillett = billettService.createBillett(request);
        // Ensure createBillett in BillettService returns the saved Billett object
        if (createdBillett == null) {
            // Handle potential errors during creation (optional)
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(createdBillett);
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
