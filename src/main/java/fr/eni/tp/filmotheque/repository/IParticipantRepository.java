package fr.eni.tp.filmotheque.repository;

import fr.eni.tp.filmotheque.bo.Membre;
import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParticipantRepository extends CrudRepository<Participant, Long> {

}
