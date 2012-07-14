package edu.sun.study.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * User: sunqipeng
 * Date: 12-7-13
 */
@Entity
public class UserInformation {
    @Id
    @GeneratedValue
    private Integer id;
    private String name = "name" + System.currentTimeMillis();
    private String address = "address" + System.currentTimeMillis();
    private Date dob = new Date();
    private String email = "email" + System.currentTimeMillis();
    private String phone = "phone" + System.currentTimeMillis();
    private String idCardNum = "idCardNum" + System.currentTimeMillis();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
