package fr.eni.tp.filmotheque.repository;

import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMembreRepository extends CrudRepository<Membre, Long> {

}
