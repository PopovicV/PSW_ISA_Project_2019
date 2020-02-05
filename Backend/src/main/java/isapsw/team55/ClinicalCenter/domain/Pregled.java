package isapsw.team55.ClinicalCenter.domain;

import isapsw.team55.ClinicalCenter.dto.PregledDTO;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Pregled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datum", nullable = false)
    private String datum;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Lekar lekar;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Sala sala;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private TipPregleda tipPregleda;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Pacijent pacijent;

    @Column(name = "rezervisan", nullable = false)
    private boolean rezervisan;

    public Pregled() {
    }

    public Pregled(String datum, Lekar lekar, Sala sala, TipPregleda tipPregleda) {
        this.datum = datum;
        this.lekar = lekar;
        this.sala = sala;
        this.tipPregleda = tipPregleda;
        this.pacijent = null;
        this.rezervisan =false;
    }

    public Pregled(String datum, Lekar lekar, Sala sala, TipPregleda tipPregleda, Pacijent pacijent) {
        this.datum = datum;
        this.lekar = lekar;
        this.sala = sala;
        this.tipPregleda = tipPregleda;
        this.pacijent = pacijent;
        this.rezervisan = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TipPregleda getTipPregleda() {
        return tipPregleda;
    }

    public void setTipPregleda(TipPregleda tipPregleda) {
        this.tipPregleda = tipPregleda;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public boolean isRezervisan() {
        return rezervisan;
    }

    public void setRezervisan(boolean rezervisan) {
        this.rezervisan = rezervisan;
    }
}
