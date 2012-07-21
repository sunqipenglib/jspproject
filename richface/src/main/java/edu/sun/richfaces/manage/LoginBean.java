package edu.sun.richfaces.manage;

import edu.sun.richfaces.beans.UserInformation;
import edu.sun.richfaces.framework.Contant;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * User: sunqipeng
 * Date: 12-7-21
 */
@SessionScoped
@ManagedBean
public class LoginBean {

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
        if (userInformation.getName().equals("admin")) {
            userInformation.setRole(UserInformation.Role.manager);
            return Contant.NAVIGATE_SUCCESS;
        }
        if (userInformation.getName().equals("worker")) {
            userInformation.setRole(UserInformation.Role.worker);
            return Contant.NAVIGATE_SUCCESS;
        }
        return Contant.NAVIGATE_FAILS;
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
