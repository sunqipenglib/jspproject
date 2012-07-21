package edu.sun.richfaces.beans;

import java.util.Date;

/**
 * User: sunqipeng
 * Date: 12-7-21
 */
public class ProjectInformation {
    private String name;
    private Date create;
    private ProjectInformation.Status status;

    private Date endDate;

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        begin, process, end;
    }
}
