package isapsw.team55.ClinicalCenter.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import isapsw.team55.ClinicalCenter.dto.LekarDTO;

import javax.persistence.*;

@Entity
public class Lekar extends Korisnik {
    @Column(name = "ime", nullable = false)
    private String ime;

    @Column(name = "prezime", nullable = false)
    private String prezime;

    @Column(name = "kontaktTelefon", nullable = false)
    private String kontaktTelefon;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JsonIgnore
    private Klinika klinika;

    @Column(name = "ocena", nullable = false)
    private float ocena;

    @Column(name = "specijalizacija", nullable = false)
    private String specijalizacija;

    @Column(name = "smena")
    private int smena;

    @Column(name = "promenioSifru", nullable = false)
    private boolean promenioSifru;

    public Lekar() {

    }

    public Lekar(String lozinka, String email, String uloga, String ime, String prezime, String kontaktTelefon,
                 Klinika klinika, float ocena, String specijalizacija, int smena) {
        super(lozinka, email, uloga);
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontaktTelefon;
        this.klinika = klinika;
        this.ocena = ocena;
        this.specijalizacija = specijalizacija;
        this.smena = smena;
        this.promenioSifru = false;
    }

    public Lekar(LekarDTO lekarDTO) {
        super("lozinka1", lekarDTO.getEmail(), "LEKAR");
        this.ime=lekarDTO.getIme();
        this.prezime = lekarDTO.getPrezime();
        this.kontaktTelefon = lekarDTO.getKontaktTelefon();
        this.ocena = (float)0.0;
        this.specijalizacija = lekarDTO.getSpecijalizacija();
        this.smena = lekarDTO.getSmena();
        this.promenioSifru = false;
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

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public String getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(String specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public int getSmena() {
        return smena;
    }

    public void setSmena(int smena) {
        this.smena = smena;
    }

    public boolean isPromenioSifru() {
        return promenioSifru;
    }

    public void setPromenioSifru(boolean promenioSifru) {
        this.promenioSifru = promenioSifru;
    }
}
