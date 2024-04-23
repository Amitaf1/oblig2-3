package com.example.oblig23.billett;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BillettNotFoundException extends RuntimeException {

    public BillettNotFoundException() {
        super ("Billett finnes ikke!");
    }
}
