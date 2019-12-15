package isapsw.team55.ClinicalCenter.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "klinika")
public class Klinika {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ime", nullable = false)
    private String ime;

    @Column(name = "adresa", nullable = false)
    private String adresa;

    @Column(name = "opis", nullable = false)
    private String opis;

    @OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<AdministratorKlinike> administratorKlinikeSet = new HashSet<AdministratorKlinike>();

    //slobodni termini za preglede
    //spisak lekara
    //spisak sala
    //cenovnik

    public void setAdministratorKlinikeSet(Set<AdministratorKlinike> administratorKlinikeSet) {
        this.administratorKlinikeSet = administratorKlinikeSet;
    }

    public Set<AdministratorKlinike> getAdministratoreKlinike() {
        return administratorKlinikeSet;
    }

    public void addAdministratorKlinike(AdministratorKlinike administratorKlinike) {
        this.administratorKlinikeSet.add(administratorKlinike);
    }

    public Klinika() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
