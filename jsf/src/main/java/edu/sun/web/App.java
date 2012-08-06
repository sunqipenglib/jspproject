package edu.sun.web;

import edu.sun.entity.Hello;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManager entityManager = Persistence.createEntityManagerFactory("dbs").createEntityManager();
        entityManager.persist(new Hello());
    }
}
