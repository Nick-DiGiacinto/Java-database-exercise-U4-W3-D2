package nick;

import nick.dao.EventiDAO;
import nick.entities.Evento;
import nick.entities.eventType;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class GestioneEventi {
    private static  final EntityManagerFactory emf = Persistence.createEntityManagerFactory("database1");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventiDAO eventoDao = new EventiDAO(em);


        System.out.println("This is your event: "+ eventoDao.getById(1));
        eventoDao.deletEvento(5);


        em.close();
        emf.close();
    }
}
