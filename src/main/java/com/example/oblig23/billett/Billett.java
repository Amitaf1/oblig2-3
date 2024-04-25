package com.example.oblig23.billett;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@Data
@Entity
@Table(name = "billett")
public class Billett {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "Film must not be blank")
    private String film;

    @NotNull(message = "Amount cannot be null")
    @Min(value = 1, message = "Amount must be at least 1")
    private Integer amount;

    @NotBlank(message = "First name is required")
    private String fname;

    @NotBlank(message = "Last name is required")
    private String lname;

    @NotNull(message = "Telephone number cannot be null")
    private Integer telnr;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    public Billett(String film, Integer amount, String fname, String lname, Integer telnr, String email) {
        this.film = film;
        this.amount = amount;
        this.fname = fname;
        this.lname = lname;
        this.telnr = telnr;
        this.email = email;
    }


    public long getId() {
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
                "film='" + film + '\'' +
                ", amount=" + amount +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", telnr=" + telnr +
                ", email='" + email + '\'' +
                '}';
    }
}
