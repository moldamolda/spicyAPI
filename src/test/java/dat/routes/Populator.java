package dat.routes;

import dat.daos.SpiceDao;
import dat.dtos.SpiceDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;


public class Populator {

    private static SpiceDao spiceDao;
    private static EntityManagerFactory emf;


    public Populator(SpiceDao spiceDao, EntityManagerFactory emf) {
        this.spiceDao = spiceDao;
        this.emf = emf;
    }

    public List<SpiceDTO> populate3Spices(){

        SpiceDTO s1, s2, s3;

        s1 = new SpiceDTO("Cumin", "Spice", "A spice that is used in many dishes");
        s2 = new SpiceDTO("Paprika", "Spice", "A spice that is used in many dishes");
        s3 = new SpiceDTO("Cayenne", "Spice", "A spice that is used in many dishes");

        s1 = spiceDao.create(s1);
        s2 = spiceDao.create(s2);
        s3 = spiceDao.create(s3);

        return new ArrayList<>(List.of(s1, s2, s3));
    }

    public void clean() {
        try (
                EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Spice").executeUpdate();
            em.createNativeQuery("ALTER SEQUENCE spice_id_seq RESTART WITH 1").executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
