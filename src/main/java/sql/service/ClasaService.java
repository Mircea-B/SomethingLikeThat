package sql.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sql.SessionFactorySingleton;
import sql.entity.Clasa;

public class ClasaService {

    private SessionFactory sessionFactory;

    public ClasaService() {
        this.sessionFactory = SessionFactorySingleton.getInstance();
    }

    public Clasa findClasaById(int id){
        Session session = sessionFactory.openSession();

        Clasa foundClasa = session.find(Clasa.class, id);

        session.close();

        return foundClasa;
    }

    public void deleteClasaById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction =  session.beginTransaction();

        Clasa clasaById = findClasaById(id);

        if(clasaById == null){
            System.out.println("Clasa " + id + " not found");
            return;
        }
        session.delete(clasaById);

        transaction.commit();
        session.close();
    }

    public Clasa addClasa(String numeClasa){
        Session session = sessionFactory.openSession();
        Transaction transaction =  session.beginTransaction();

        Clasa clasa = new Clasa(numeClasa);
        session.persist(clasa);

        transaction.commit();
        session.close();

        return clasa;
    }
}
