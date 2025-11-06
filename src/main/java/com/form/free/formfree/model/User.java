package com.form.free.formfree.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class User {
    @Id
    private Long id;

    private String name;
    private String userName;
    private String password;
    private String roles;
    private boolean enabled;
    private String email;
    private String phone;
    private String address;
    private Integer wallet_amount;
    private Integer numOfProjects;

    @OneToMany(mappedBy = "user")
    private List<Projects> projects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getWallet_amount() {
        return wallet_amount;
    }

    public void setWallet_amount(Integer wallet_amount) {
        this.wallet_amount = wallet_amount;
    }

    public Integer getNumOfProjects() {
        return numOfProjects;
    }

    public void setNumOfProjects(Integer numOfProjects) {
        this.numOfProjects = numOfProjects;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Projects> getProjects() {
        return projects;
    }

    public void setProjects(List<Projects> projects) {
        this.projects = projects;
    }
}
