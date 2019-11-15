package isapsw.team55.ClinicalCenter.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Pregled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cenaPregeleda", nullable = false)
    private float cenaPregleda;

    @Column(name = "datum", nullable = false)
    private String datum;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Lekar lekar;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Sala sala;

    public Pregled() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getCenaPregleda() {
        return cenaPregleda;
    }

    public void setCenaPregleda(float cenaPregleda) {
        this.cenaPregleda = cenaPregleda;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Lekar getLekar() {
        return lekar;
    }

    public void setLekar(Lekar lekar) {
        this.lekar = lekar;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pregled t = (Pregled) o;
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
