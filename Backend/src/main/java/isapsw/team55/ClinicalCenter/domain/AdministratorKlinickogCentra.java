package isapsw.team55.ClinicalCenter.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
public class AdministratorKlinickogCentra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lozinka", unique = false, nullable = false)
    private String lozinka;

    @Column(name = "ime", unique = false, nullable = false)
    private String ime;

    @Column(name = "prezime", unique = false, nullable = false)
    private String prezime;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "kontaktTelefon", unique = false, nullable = false)
    private String kontaktTelefon;

    //@OneToMany(mappedBy = "administratorKlinickogCentra", fetch = FetchType.LAZY, cascade = CascadeType.ALL)\
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private KlinickiCentar klinickiCentar;

    public AdministratorKlinickogCentra() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
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
