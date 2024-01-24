package it.epicode;

import it.epicode.dao.EventoDAO;
import it.epicode.entities.Evento;
import it.epicode.entities.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.UUID;

public class Application {
private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BE-U4-W3-D2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(em);

        Evento vanGoghExperience = new Evento("Van Gogh Experience", LocalDate.of(2024, 10, 4),"La prima grande mostra multimediale del Next Museum dedicata al grande pittore olandese!", TipoEvento.PUBBLICO, 20000);

        eventoDAO.save(vanGoghExperience);

        UUID id = UUID.fromString("2a3b10ed-5291-7318-feae-6effea1da3e8");
        Evento eventoDB = eventoDAO.getById(id);
        if (eventoDB != null) {
            System.out.println(eventoDB.toString());
        } else {
            System.out.println("Evento con id " + id + " non trovato");
        }

        eventoDAO.deleteById(id);
        em.close();
    }
}
