package com.userlist.model;

import javax.persistence.*;

@Entity
@Table (name = "USER_TABLE")
public class User
{
    @Id
    @Column(name = "USER_ID")
    private Integer id;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_SURNAME")
    private String surname;

    @Column(name = "USER_PASS")
    private String password;

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
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public User (Integer id, String name, String surname, String password)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }
}
