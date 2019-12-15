package isapsw.team55.ClinicalCenter.domain;

import isapsw.team55.ClinicalCenter.dto.AdministratorKlinikeDTO;

import javax.persistence.*;

@Entity
@Table(name = "administrator_klinike")
public class AdministratorKlinike extends Korisnik{

    @Column(name = "ime", nullable = false)
    private String ime;

    @Column(name = "prezime", nullable = false)
    private String prezime;

    @Column(name = "kontaktTelefon", nullable = false)
    private String kontaktTelefon;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Klinika klinika;

    public AdministratorKlinike() {
        super();
    }

    public AdministratorKlinike(AdministratorKlinikeDTO ak) {
        this.id = ak.getId();
        this.email = ak.getEmail();
        this.ime = ak.getIme();
        this.klinika = ak.getKlinika();
        this.kontaktTelefon = ak.getKontaktTelefon();
        this.prezime = ak.getPrezime();
        this.lozinka = ak. getLozinka();
        this.uloga = "ADMINISTRATOR_KLINIKE";
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public Klinika getKlinika() {
        return klinika;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public void setKlinika(Klinika klinika) {
        this.klinika = klinika;
    }
}
