package fr.eni.tp.filmotheque.converter;

import fr.eni.tp.filmotheque.bll.service.FilmService;
import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConverterParticipant implements Converter<String, Participant> {

    @Autowired
    FilmService filmServiceBouchon;

    @Override
    public Participant convert(String source) {
        int id = Integer.parseInt(source);

        return this.filmServiceBouchon.getParticipantById(id);
    }
}
