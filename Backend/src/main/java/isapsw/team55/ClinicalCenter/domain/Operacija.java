package isapsw.team55.ClinicalCenter.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Operacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pacijent_id", referencedColumnName = "id")
    private Pacijent pacijent;

    @ManyToMany
    @JoinTable(name = "operacija_lekari",
            joinColumns = { @JoinColumn(name = "id")},
            inverseJoinColumns = { @JoinColumn (name = "lekar_id", referencedColumnName = "id")})
    private List<Lekar> lekari = new ArrayList<Lekar>();

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "sala_id", referencedColumnName = "id")
    private Sala sala;

    @Column(name = "tipOperacije", nullable = false)
    private String tipOperacije;

    @Column(name = "cena", nullable = false)
    private float cena;

    @Column(name = "datum", nullable = false)
    private String datum;


    @Column(name = "trajanje", nullable = false)
    private int trajanje;

    public Operacija() {
    }

    public Operacija(Pacijent pacijent, List<Lekar> lekari, Sala sala, float cena, String datum, int trajanje, String tipOperacije) {
        this.pacijent = pacijent;
        this.lekari = lekari;
        this.sala = sala;
        this.cena = cena;
        this.datum = datum;
        this.trajanje = trajanje;
        this.tipOperacije = tipOperacije;
    }

    public Long getId() {
        return id;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public List<Lekar> getLekari() {
        return lekari;
    }

    public Sala getSala() {
        return sala;
    }

    public float getCena() {
        return cena;
    }

    public String getDatum() {
        return datum;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public void setLekari(List<Lekar> lekari) {
        this.lekari = lekari;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public String getTipOperacije() {
        return tipOperacije;
    }

    public void setTipOperacije(String tipOperacije) {
        this.tipOperacije = tipOperacije;
    }


}
