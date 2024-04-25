package com.example.oblig23.billett;

import jakarta.validation.constraints.NotEmpty;
import org.jetbrains.annotations.NotNull;

public class BillettRequest {

    @NotEmpty(message = "Film name must not be empty")
    private String film;

    @NotNull
    private Integer amount;

    @NotEmpty
    private String fname;

    @NotEmpty
    private String lname;

    @NotNull
    private Integer telnr;

    @NotEmpty
    private String email;

    public BillettRequest() {
    }

    // Constructor with parameters (useful for creating instances)
    public BillettRequest(String film, Integer amount, String fname, String lname, Integer telnr, String email) {
        this.film = film;
        this.amount = amount;
        this.fname = fname;
        this.lname = lname;
        this.telnr = telnr;
        this.email = email;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getTelnr() {
        return telnr;
    }

    public void setTelnr(Integer telnr) {
        this.telnr = telnr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "BillettRequest{" +
                "film='" + film + '\'' +
                ", amount=" + amount +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", telnr=" + telnr +
                ", email='" + email + '\'' +
                '}';
    }
}

