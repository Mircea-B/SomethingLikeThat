package sql.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sql.SessionFactorySingleton;
import sql.entity.Clasa;
import sql.entity.Elevi;

import java.util.List;

public class ElevService {

    private SessionFactory sessionFactory;
    private ClasaService clasaService;

    public ElevService() {
        this.sessionFactory = SessionFactorySingleton.getInstance();
        this.clasaService = new ClasaService();
    }

    public Elevi findElevById(int id) {

        Session session = sessionFactory.openSession();

        Elevi foundElev = session.find(Elevi.class, id);
        session.close();
        return foundElev;

    }

    public void deleteElevById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Elevi eleviByid = findElevById(id);
        if (eleviByid == null) {
            System.out.println("elevul " + id + " nu este valabil");
        }
        session.delete(findElevById(id));
        transaction.commit();
        session.close();
    }

    public Elevi addElev(String numeElev, int idclasa) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Clasa clasaById = clasaService.findClasaById(idclasa);
        Elevi elevi = new Elevi(numeElev, clasaById);
        session.persist(elevi);

        transaction.commit();
        session.close();
        return elevi;

    }

    public List<Elevi> findAllElevi(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query allEleviQuery = session.createQuery("select e from Elevi e");
        List<Elevi> list = allEleviQuery.getResultList();

        transaction.commit();
        session.close();
        return list;
    }

    public Elevi findElevByName(String name){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query specificElevQuery = session.createQuery("select e from Elevi e " +
                "where e.numeElev = :name");
        specificElevQuery.setParameter("name", name);

        Elevi toBeReturned = (Elevi) specificElevQuery.uniqueResult();

        transaction.commit();
        session.close();

        return toBeReturned;
    }


    @Override
    public String toString() {
        return "ElevService{" +
                "sessionFactory=" + sessionFactory +
                ", clasaService=" + clasaService +
                '}';
    }
}