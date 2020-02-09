package isapsw.team55.ClinicalCenter.domain;

import isapsw.team55.ClinicalCenter.dto.AdministratorKlinickogCentraDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Table(name = "administrator_klinickog_centra")
public class AdministratorKlinickogCentra extends Korisnik {

    @Column(name = "ime", unique = false, nullable = false)
    private String ime;

    @Column(name = "prezime", unique = false, nullable = false)
    private String prezime;

    @Column(name = "kontaktTelefon", unique = false, nullable = false)
    private String kontaktTelefon;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Klinika> klinikaList;

    public AdministratorKlinickogCentra() {
        super();
    }

    public AdministratorKlinickogCentra(AdministratorKlinickogCentraDTO akcdto) {
        this.id = akcdto.getId();
        this.lozinka = akcdto.getLozinka();
        this.ime = akcdto.getIme();
        this.prezime = akcdto.getPrezime();
        this.email = akcdto.getEmail();
        this.kontaktTelefon = akcdto.getKontaktTelefon();
        this.uloga = "ADMINISTRATOR_KLINICKOG_CENTRA";
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

    public void addKlinika(Klinika klinika) {
        klinikaList.add(klinika);
    }
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(id);
//    }

}
