package com.example.oblig23.billett;

public class BillettRequest {

    private String film;
    private Integer amount;
    private String fname;
    private String lname;
    private Integer telnr;
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
}

