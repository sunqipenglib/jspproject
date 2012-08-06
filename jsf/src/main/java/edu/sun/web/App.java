package edu.sun.web;

import edu.sun.entity.Hello;
import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class App {

    //static Logger logger = Logger.getLogger(App.class);

    static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {


        EntityManager entityManager = Persistence.createEntityManagerFactory("dbs").createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        for (int i = 0; i < 1000; i++)
            entityManager.persist(new Hello());
        entityTransaction.commit();

        logger.info(entityManager.createQuery("select u from Hello  u").getResultList().size());
    }
}
