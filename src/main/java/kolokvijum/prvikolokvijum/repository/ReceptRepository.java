package kolokvijum.prvikolokvijum.repository;

import kolokvijum.prvikolokvijum.model.Recept;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptRepository extends CrudRepository<Recept, Long> {
}
