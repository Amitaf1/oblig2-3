package com.example.oblig23.billett;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class BillettJsonDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(BillettJsonDataLoader.class);
    private final BillettRepository billettRepository;
    private final ObjectMapper objectMapper;

    public BillettJsonDataLoader(BillettRepository billettRepository, ObjectMapper objectMapper) {
        this.billettRepository = billettRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public void run(String... args) throws Exception {
        if (billettRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/billetter.json")) {
                Billetter alleBilletter = objectMapper.readValue(inputStream, Billetter.class);
                log.info("Reading {} billetter from JSON data and saving it to a database.", alleBilletter.billetter().size());
                billettRepository.saveAll(alleBilletter.billetter());
            }
            catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        }
        else {
            log.info("Not loading Billetter from JSON data because the collection contains data.");
        }
    }
}
