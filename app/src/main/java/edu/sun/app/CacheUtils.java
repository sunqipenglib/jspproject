package edu.sun.app;

import edu.sun.entity.Page;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * User: sunqipeng
 * Date: 12-8-7
 */
public class CacheUtils {


    /**
     * @param url
     */
    public static void addUrl(Page url) {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(url);
        entityTransaction.commit();
        entityManager.close();
    }

    /**
     * @param urls
     */
    public static void addUrls(List<Page> urls) {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        for (Page page : urls) {
            if (!validateUrlExist(page.getPageUrl(), entityManager))
                entityManager.persist(page);
        }
        entityTransaction.commit();
        entityManager.close();
    }

    private static boolean validateUrlExist(String url, EntityManager entityManager) {
        return entityManager.createQuery("select  p from Page  p where p.pageUrl=:url").setParameter("url", url).getResultList().size() > 0;
    }

    public static void saveVisitedUrl(Page page) {

        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        page.setPageVisited(true);
        entityManager.merge(page);
        entityTransaction.commit();


    }

    /**
     * @return
     */
    public static Page getNextPage() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        Page page = (Page) entityManager.createQuery("select p from Page p where p.pageVisited=false order by id desc").getResultList().get(0);
        entityManager.close();
        return page;
    }

    public static void saveUrl(Page page) {
        //To change body of created methods use File | Settings | File Templates.
    }
}
