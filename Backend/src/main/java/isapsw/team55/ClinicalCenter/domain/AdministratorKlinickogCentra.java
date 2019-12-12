package isapsw.team55.ClinicalCenter.domain;

import isapsw.team55.ClinicalCenter.dto.AdministratorKlinickogCentraDTO;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "administrator_klinickog_centra")
public class AdministratorKlinickogCentra extends Korisnik {

    @Column(name = "ime", unique = false, nullable = false)
    private String ime;

    @Column(name = "prezime", unique = false, nullable = false)
    private String prezime;

    @Column(name = "kontaktTelefon", unique = false, nullable = false)
    private String kontaktTelefon;

    //@OneToMany(mappedBy = "administratorKlinickogCentra", fetch = FetchType.LAZY, cascade = CascadeType.ALL)\
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private KlinickiCentar klinickiCentar;

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
        this.klinickiCentar = akcdto.getKlinickiCentar();
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

    public KlinickiCentar getKlinickiCentar() {
        return klinickiCentar;
    }

    public void setKlinickiCentar(KlinickiCentar klinickiCentar) {
        this.klinickiCentar = klinickiCentar;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hashCode(id);
//    }

}
