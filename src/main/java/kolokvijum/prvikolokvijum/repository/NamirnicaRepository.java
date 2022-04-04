package kolokvijum.prvikolokvijum.repository;

import kolokvijum.prvikolokvijum.model.Namirnica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NamirnicaRepository extends CrudRepository<Namirnica, Long> {
    @Query("SELECT n FROM Namirnica n WHERE n.cena > :minCena AND n.cena < :maxCena AND n.kalorijskaVrednost < :minKalorijskaVrednost AND n.kalorijskaVrednost > :maxKalorijskaVrednost")
    public Iterable<Namirnica> findByCenaBetweenOOrKalorijskaVrednostBetween(Double minCena, Double maxCena, Double minKalorijskaVrednost, Double maxKalorijskaVrednost);

    @Query("SELECT n From Namirnica n WHERE n.naziv= :naziv")
    public Iterable<Namirnica> findByNazivLike(String naziv);
}
