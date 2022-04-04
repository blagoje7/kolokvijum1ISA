package kolokvijum.prvikolokvijum.model;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Namirnica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @Column(nullable = false)
    private Double kalorijskaVrednost;

    @Column(nullable = false)
    private Double cena;

    @Column(nullable = false)
    private String mernaJedinica;

    @OneToMany(mappedBy = "namirnica")
    private Set<Sastojak> sastojci = new HashSet<Sastojak>();

    public Namirnica() {
        super();
    }

    public Namirnica(Long id, String naziv, Double kalorijskaVrednost, Double cena, String mernaJedinica, Set<Sastojak> sastojci) {
        this.id = id;
        this.naziv = naziv;
        this.kalorijskaVrednost = kalorijskaVrednost;
        this.cena = cena;
        this.mernaJedinica = mernaJedinica;
        this.sastojci = sastojci;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getKalorijskaVrednost() {
        return kalorijskaVrednost;
    }

    public void setKalorijskaVrednost(Double kalorijskaVrednost) {
        this.kalorijskaVrednost = kalorijskaVrednost;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String getMernaJedinica() {
        return mernaJedinica;
    }

    public void setMernaJedinica(String mernaJedinica) {
        this.mernaJedinica = mernaJedinica;
    }

    public Set<Sastojak> getSastojci() {
        return sastojci;
    }

    public void setSastojci(Set<Sastojak> sastojci) {
        this.sastojci = sastojci;
    }
}
