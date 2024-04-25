package com.example.oblig23.billett;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BillettServiceImpl implements BillettService {

    private final Repository repository;

    @Autowired
    private BillettRepository billettRepository;

    // Implement other methods (createBillett, updateBillett, etc.)

    @Override
    public List<Billett> getAllBilletter() {
        // Retrieve all Billets from the repository
        return billettRepository.findAll();
    }

    @Autowired
    public BillettServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Billett createBillett(BillettRequest request) {
        Billett billett = new Billett(
                request.getFilm(),
                request.getAmount(),
                request.getFname(),
                request.getLname(),
                request.getTelnr(),
                request.getEmail()
        );
        return repository.save(billett);
    }

    @Override
    public Billett updateBillett(Integer id, BillettRequest request) {
        Billett existingBillett = getBillettById(id);
        existingBillett.setFilm(request.getFilm());
        existingBillett.setAmount(request.getAmount());
        existingBillett.setFname(request.getFname());
        existingBillett.setLname(request.getLname());
        existingBillett.setTelnr(request.getTelnr());
        existingBillett.setEmail(request.getEmail());
        return repository.save(existingBillett);
    }

    @Override
    public Billett getBillettById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Billett not found with id: " + id));
    }

    @Override
    public void slettAlleBilletter() {
        repository.deleteAll();
    }
}
