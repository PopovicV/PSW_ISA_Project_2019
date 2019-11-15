package isapsw.team55.ClinicalCenter.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Klinika {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    public Klinika() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
