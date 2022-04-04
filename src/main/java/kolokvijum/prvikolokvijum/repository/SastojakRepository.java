package kolokvijum.prvikolokvijum.repository;

import kolokvijum.prvikolokvijum.model.Sastojak;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SastojakRepository extends CrudRepository<Sastojak, Long> {
}
