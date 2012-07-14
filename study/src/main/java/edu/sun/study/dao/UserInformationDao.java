package edu.sun.study.dao;

import edu.sun.study.po.UserInformation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * User: sunqipeng
 * Date: 12-7-13
 */
@Repository
@Transactional
public class UserInformationDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save10() {
        UserInformation userInformation = new UserInformation();
        userInformation.setName("name" + System.currentTimeMillis());
        entityManager.persist(userInformation);
    }

    public Integer getCount() {
        return Integer.parseInt(entityManager.createQuery("select count(user) from UserInformation user").getSingleResult().toString());
    }

    public List list() {
        return entityManager.createQuery("select u from UserInformation u").getResultList();
    }
}
