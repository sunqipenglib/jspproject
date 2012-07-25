package edu.sun.richfaces.manage;

import edu.sun.richfaces.beans.UserInformation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: sunqipeng
 * Date: 12-7-25
 */
@ManagedBean
@ViewScoped
public class MainBean implements Serializable {

    public List<String> values = new ArrayList<String>();

    public List<UserInformation> userInformations = new ArrayList<UserInformation>();

    public List<UserInformation> getUserInformations() {
        return userInformations;
    }

    public void setUserInformations(List<UserInformation> userInformations) {
        this.userInformations = userInformations;
    }

    private String testName;

    public String getTestName() {
        return new Date().toString() + testName;
    }


    public void helloAjax() {
        userInformations.add(new UserInformation());
        System.out.println("this the message invoked");
        testName = new Date().toString();

    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
