package com.worldskills.wsapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String ip;

    @Column
    private Date lastenter;

    @Column
    private String services;

    @Column
    private Byte type;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLastenter() {
        return lastenter;
    }

    public void setLastenter(Date lastenter) {
        this.lastenter = lastenter;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", ip='" + ip + '\'' +
                ", lastenter=" + lastenter +
                ", services='" + services + '\'' +
                ", type=" + type +
                '}';
    }
}