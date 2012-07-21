package edu.sun.richfaces.manage;

import edu.sun.richfaces.beans.UserInformation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * User: sunqipeng
 * Date: 12-7-21
 */
@ViewScoped
@ManagedBean
public class LoginBean {

    private UserInformation userInformation;

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public String login() {
        return "";
    }
}
