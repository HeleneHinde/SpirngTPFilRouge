package fr.eni.tp.filmotheque.repository;

import fr.eni.tp.filmotheque.bo.Avis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAvisRepository extends CrudRepository<Avis, Long> {

}
