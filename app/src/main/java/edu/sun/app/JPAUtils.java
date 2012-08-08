package edu.sun.app;

import edu.sun.core.Contants;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * User: sunqipeng
 * Date: 12-8-7
 */
public class JPAUtils {
    static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null)
            entityManagerFactory = Persistence.createEntityManagerFactory(Contants.PERSISTENCE_UNIT);
        return entityManagerFactory.createEntityManager();
    }
}
