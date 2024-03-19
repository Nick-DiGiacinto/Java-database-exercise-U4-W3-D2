package nick.dao;

import nick.entities.Evento;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;

import java.util.logging.Logger;

public class EventiDAO {

    private final EntityManager em;

    public EventiDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Evento evento){
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(evento);
            transaction.commit();
            System.out.println("Event saved successfully");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    };

    public Evento getById(long id) {
        try {
            Evento evento = em.find(Evento.class, id);
            if (evento != null) {
                return evento;
            } else {
                throw new EntityNotFoundException("Event number " + id + " not found");

            }
        } catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
            throw new RuntimeException("Error " + ex);}}


    public void deletEvento(long id){
        Evento found = this.getById(id);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Event number " + id + "delite successfully");

    };

};

