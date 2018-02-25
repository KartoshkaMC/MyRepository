package com.userlist.model;

import javax.persistence.*;

@Entity
@Table(name = "AUTO")
public class Auto
{
    @Id
    @Column(name = "AUTO_ID")
    Integer id;

    @Column(name = "AUTO_NAME")
    String name;

    String nameUser;
    @Column(name = "AUTO_IMG")
    String url;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNameUser() {
        return nameUser;
    }
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Auto(Integer id, String name, String url)
    {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public Auto(Integer id, String nameUser, String name, String url)
    {
        this.id = id;
        this.nameUser = nameUser;
        this.name = name;
        this.url = url;
    }
}
