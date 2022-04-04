package kolokvijum.prvikolokvijum.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sastojak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Double kolicina;

    @ManyToOne(optional = false)
    private Namirnica namirnica;

    @OneToMany(mappedBy = "sastojak")
    private Set<Recept> recepti = new HashSet<Recept>();

    public Sastojak() {
        super();
    }

    public Sastojak(Long id, Double kolicina, Namirnica namirnica, Set<Recept> recepti) {
        this.id = id;
        this.kolicina = kolicina;
        this.namirnica = namirnica;
        this.recepti = recepti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getKolicina() {
        return kolicina;
    }

    public void setKolicina(Double kolicina) {
        this.kolicina = kolicina;
    }

    public Namirnica getNamirnica() {
        return namirnica;
    }

    public void setNamirnica(Namirnica namirnica) {
        this.namirnica = namirnica;
    }

    public Set<Recept> getRecepti() {
        return recepti;
    }

    public void setRecepti(Set<Recept> recepti) {
        this.recepti = recepti;
    }
}
