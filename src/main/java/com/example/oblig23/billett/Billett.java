package com.example.oblig23.billett;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@Data
public class Billett {

    private Integer id;
    private String film;
    private Integer amount;
    private String fname;
    private String lname;
    private Integer telnr;
    private String email;

    public Billett(Integer id, String film, Integer amount, String fname, String lname, Integer telnr, String email) {
        this.id = id;
        this.film = film;
        this.amount = amount;
        this.fname = fname;
        this.lname = lname;
        this.telnr = telnr;
        this.email = email;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Billett billett = (Billett) o;
        return Objects.equals(id, billett.id) && Objects.equals(film, billett.film) && Objects.equals(amount, billett.amount) && Objects.equals(fname, billett.fname) && Objects.equals(lname, billett.lname) && Objects.equals(telnr, billett.telnr) && Objects.equals(email, billett.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, film, amount, fname, lname, telnr, email);
    }

    @Override
    public String toString() {
        return "Billett{" +
                "id=" + id +
                ", film='" + film + '\'' +
                ", amount=" + amount +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", telnr=" + telnr +
                ", email='" + email + '\'' +
                '}';
    }
}
