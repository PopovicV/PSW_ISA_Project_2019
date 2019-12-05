package isapsw.team55.ClinicalCenter.domain;

import isapsw.team55.ClinicalCenter.dto.MedicinskoOsobljeDTO;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class MedicinskoOsoblje extends Korisnik{
    @Column(name = "ime", nullable = false)
    private String ime;

    @Column(name = "prezime", nullable = false)
    private String prezime;

    @Column(name = "kontaktTelefon", nullable = false)
    private String kontaktTelefon;

    public MedicinskoOsoblje() {
    }

    public MedicinskoOsoblje(MedicinskoOsobljeDTO mo) {
        this.id = mo.getId();
        this.email = mo.getEmail();
        this.ime = mo.getIme();
        this.kontaktTelefon = mo.getKontaktTelefon();
        this.prezime = mo.getPrezime();
        this.lozinka = mo. getLozinka();
        this.uloga = "MEDICINSKO_OSOBLJE";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MedicinskoOsoblje t = (MedicinskoOsoblje) o;
        if (t.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, t.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
