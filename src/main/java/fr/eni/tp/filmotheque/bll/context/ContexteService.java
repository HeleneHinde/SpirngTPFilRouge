package fr.eni.tp.filmotheque.bll.context;

import fr.eni.tp.filmotheque.bo.Membre;

public interface ContexteService {


    Membre charger(String email);
}
