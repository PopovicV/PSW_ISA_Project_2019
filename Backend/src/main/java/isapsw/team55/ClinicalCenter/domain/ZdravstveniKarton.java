package isapsw.team55.ClinicalCenter.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name="zdravstveni_karton")
public class ZdravstveniKarton {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pacijenta", referencedColumnName = "id")
    private Pacijent pacijent;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "zdravstveni_karton_dijagnoze",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = { @JoinColumn( name = "dijagnoza_id", referencedColumnName = "id")})
    private List<Dijagnoza> dijagnoze = new ArrayList<Dijagnoza>();

    public ZdravstveniKarton() {
    }

    public Long getId() {
        return id;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public ZdravstveniKarton(Pacijent pacijent, List<Dijagnoza> dijagnoze) {
        this.pacijent = pacijent;
        this.dijagnoze = dijagnoze;
    }

    public List<Dijagnoza> getDijagnoze() {
        return dijagnoze;
    }

    public void setDijagnoze(List<Dijagnoza> dijagnoze) {
        this.dijagnoze = dijagnoze;
    }
}
