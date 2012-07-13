package edu.sun.study.dao;

import edu.sun.study.po.UserInfomation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        for (int i = 0; i < 1; i++) {
            UserInfomation userInformation = new UserInfomation();
            userInformation.setName("name" + System.currentTimeMillis());
            entityManager.persist(userInformation);
        }
    }

    public Integer getCount() {
        return Integer.parseInt(entityManager.createQuery("select count(user) from UserInfomation user").getSingleResult().toString());
    }
}
