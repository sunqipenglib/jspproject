package edu.sun.app;

import edu.sun.entity.Hello;
import edu.sun.entity.Page;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction et = entityManager.getTransaction();
        et.begin();
        for (int i = 0; i < 10; i++)
            entityManager.persist(new Hello());
        et.commit();
        System.out.println(entityManager.createQuery("select h from Hello  h ").getResultList().size());

        CacheUtils.addUrl(new Page("http://www.163.com", 1));
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++)
            executorService.execute(new Crawler());
        executorService.shutdown();
        while (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {

        }

        System.out.println("application exit");
    }
}
