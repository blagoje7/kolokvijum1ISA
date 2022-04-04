package kolokvijum.prvikolokvijum.model;

import javax.persistence.*;

@Entity
public class Recept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @Column(nullable = false)
    private String postupak;

    @Column(nullable = false)
    private Double brojPorcija;

    @ManyToOne(optional = false)
    private Sastojak sastojak;

    public Recept() {
        super();
    }

    public Recept(Long id, String naziv, String postupak, Double brojPorcija, Sastojak sastojak) {
        this.id = id;
        this.naziv = naziv;
        this.postupak = postupak;
        this.brojPorcija = brojPorcija;
        this.sastojak = sastojak;
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

    public String getPostupak() {
        return postupak;
    }

    public void setPostupak(String postupak) {
        this.postupak = postupak;
    }

    public Double getBrojPorcija() {
        return brojPorcija;
    }

    public void setBrojPorcija(Double brojPorcija) {
        this.brojPorcija = brojPorcija;
    }

    public Sastojak getSastojak() {
        return sastojak;
    }

    public void setSastojak(Sastojak sastojak) {
        this.sastojak = sastojak;
    }
}
