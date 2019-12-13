package isapsw.team55.ClinicalCenter.dto;

import isapsw.team55.ClinicalCenter.domain.AdministratorKlinike;
import isapsw.team55.ClinicalCenter.domain.Klinika;

public class AdministratorKlinikeDTO {
    private Long id;
    private String lozinka;
    private String ime;
    private String prezime;
    private String email;
    private String kontaktTelefon;
    private Klinika klinika;

    public AdministratorKlinikeDTO() {

    }

    public AdministratorKlinikeDTO(AdministratorKlinike administratorKlinike) {
        this(administratorKlinike.getId(), administratorKlinike.getLozinka(), administratorKlinike.getIme(), administratorKlinike.getPrezime()
        , administratorKlinike.getEmail(), administratorKlinike.getKontaktTelefon(), administratorKlinike.getKlinika());
    }

    public AdministratorKlinikeDTO(Long id, String lozinka, String ime, String prezime, String email, String kontaktTelefon, Klinika klinika) {
        this.id = id;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.kontaktTelefon = kontaktTelefon;
        this.klinika = klinika;
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

    public Klinika getKlinika() {
        return klinika;
    }

    public void setKlinika(Klinika klinika) {
        this.klinika = klinika;
    }
}
