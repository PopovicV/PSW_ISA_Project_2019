package isapsw.team55.ClinicalCenter.domain;

import isapsw.team55.ClinicalCenter.dto.SalaDTO;

import javax.persistence.*;

@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Klinika klinika;

    @Column(name = "naziv", nullable = false)
    private String naziv;

    public Sala() {
    }

    public Sala(SalaDTO salaDTO) {
        this.naziv = salaDTO.getNaziv();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Klinika getKlinika() {
        return klinika;
    }

    public void setKlinika(Klinika klinika) {
        this.klinika = klinika;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
