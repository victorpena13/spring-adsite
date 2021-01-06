package com.winter.adlist.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id@GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String firstname;

    @Column(nullable = true)
    private String lastname;

    @Column(nullable=true)
    private String photo;

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "owner" )
    private List<Ad> ad;



    public User(){
    }
    public User(String username, String email, String password, String firstname, String lastname,  String photo, List<Ad> ad) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.photo = photo;
        this.ad = ad;
    }
    public User(User copy){
        this.id=copy.id;
        this.username = copy.username;
        this.email = copy.email;
        this.password = copy.password;
        this.firstname = copy.firstname;
        this.lastname = copy.lastname;
        this.photo= copy.photo;
        this.ad = copy.ad;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public List<Ad> getAd() {
        return ad;
    }
    public void setAd(List<Ad> ad) {
        this.ad = ad;
    }

}