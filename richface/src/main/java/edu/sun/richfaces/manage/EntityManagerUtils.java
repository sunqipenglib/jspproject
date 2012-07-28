package edu.sun.richfaces.manage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * User: sunqipeng
 * Date: 12-7-28
 */
public class EntityManagerUtils {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("richface");

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
