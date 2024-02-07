package fr.eni.tp.filmotheque.repository;

import fr.eni.tp.filmotheque.bo.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFilmRepository extends CrudRepository<Film, Long> {

}
