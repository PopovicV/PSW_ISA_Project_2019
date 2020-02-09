package isapsw.team55.ClinicalCenter.domain;

import javax.persistence.*;

@Entity
@Table(name="dijagnoza")
public class Dijagnoza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sifraDijagnoze", nullable = false)
    private String sifraDijagnoze;

    @Column(name="naziv", nullable = false)
    private String nazivDijagnoze;

    public Dijagnoza() {
    }

    public Dijagnoza(String sifraDijagnoze, String nazivDijagnoze) {
        this.sifraDijagnoze = sifraDijagnoze;
        this.nazivDijagnoze = nazivDijagnoze;
    }

    public Long getId() {
        return id;
    }

    public String getSifraDijagnoze() {
        return sifraDijagnoze;
    }

    public String getNazivDijagnoze() {
        return nazivDijagnoze;
    }

    public void setId(Long dijagnoza_id) {
        this.id = id;
    }

    public void setSifraDijagnoze(String sifraDijagnoze) {
        this.sifraDijagnoze = sifraDijagnoze;
    }

    public void setNazivDijagnoze(String nazivDijagnoze) {
        this.nazivDijagnoze = nazivDijagnoze;
    }


}
