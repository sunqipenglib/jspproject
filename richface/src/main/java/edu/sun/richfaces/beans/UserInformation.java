package edu.sun.richfaces.beans;

/**
 * User: sunqipeng
 * Date: 12-7-21
 */
public class UserInformation {
    private String name;
    private String password;
    private UserInformation.Role role;
    private String firstName;
    private String lastName;


    public enum Role {
        manager, worker;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
