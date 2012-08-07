package edu.sun.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * User: sunqipeng
 * Date: 12-8-7
 */
@Entity
public class Page {
    @Id
    @GeneratedValue
    private int id;
    private String pageUrl;
    private String pageTitle;
    private int h1Count;
    private int h2Count;
    private int pageSize;
    private boolean pageVisited;
    private int pageDepth;
    private int responseCode;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public Page() {
    }

    public Page(String s, int i) {
        this.pageUrl = s;
        this.pageDepth = i;
    }

    public int getH1Count() {
        return h1Count;
    }

    public void setH1Count(int h1Count) {
        this.h1Count = h1Count;
    }

    public int getH2Count() {
        return h2Count;
    }

    public void setH2Count(int h2Count) {
        this.h2Count = h2Count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPageDepth() {
        return pageDepth;
    }

    public void setPageDepth(int pageDepth) {
        this.pageDepth = pageDepth;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public boolean isPageVisited() {
        return pageVisited;
    }

    public void setPageVisited(boolean pageVisited) {
        this.pageVisited = pageVisited;
    }
}
