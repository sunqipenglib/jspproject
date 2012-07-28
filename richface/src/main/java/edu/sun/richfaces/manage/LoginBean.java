package edu.sun.richfaces.manage;

import edu.sun.richfaces.beans.UserInformation;
import edu.sun.richfaces.framework.Contant;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.io.Serializable;

/**
 * User: sunqipeng
 * Date: 12-7-21
 */
@SessionScoped
@ManagedBean
public class LoginBean implements Serializable {

    @PersistenceContext
    EntityManager entityManager;

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private UserInformation userInformation;

    private boolean login;

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public UserInformation getUserInformation() {
        if (userInformation == null)
            userInformation = new UserInformation();
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    /**
     * validate user's password and name is consiste
     *
     * @return
     */
    public String login() {

        entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("richface");
        if (entityManager == null) {
            System.out.println("the entity manager is null");
        } else {
            System.out.println("entity manager is not null");
        }
        if (entityManagerFactory == null) {
            System.out.println("the entityManagerFactory  is null");
        } else {
            System.out.println("entityManagerFactory is not null");
        }

        return "main";
        //if (userInformation.getName().equals("admin")) {
//            userInformation.setRole(UserInformation.Role.manager);
//            return Contant.NAVIGATE_SUCCESS;
//        }
//        if (userInformation.getName().equals("worker")) {
//            userInformation.setRole(UserInformation.Role.worker);
//            return Contant.NAVIGATE_SUCCESS;
//        }
//        HtmlDataTable dataTable;
//
//        return Contant.NAVIGATE_FAILS;
    }

    public String logout() {
        login = false;
        userInformation = null;
        return Contant.NAVIGATE_LOGOUT;
    }


    /**
     * if current user is a manager, then he can create new project
     *
     * @return
     */
    public boolean createNewProject() {
        if (userInformation.getRole() == UserInformation.Role.manager) {
            return true;
        }
        return false;
    }
}
