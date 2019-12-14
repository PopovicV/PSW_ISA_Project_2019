package isapsw.team55.ClinicalCenter.domain;

import javax.persistence.*;

@Entity
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

    //slobodni termini za preglede
    //spisak lekara
    //spisak sala
    //cenovnik

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
