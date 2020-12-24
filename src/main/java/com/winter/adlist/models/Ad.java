package com.winter.adlist.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ads")
public class Ad {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private Date createdAt;

    @Column(nullable=true)
    private String photo;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User owner;


    @ManyToOne
    @JoinColumn (name="category_id")
    private Category categories;


    public Ad() {
    }
    public Ad(String title, String body, Date createdAt, String photo, User owner, Category categories) {
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
        this.photo = photo;
        this.owner = owner;
        this.categories = categories;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }


    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public Category getCategories() {
        return categories;
    }
    public void setCategories( Category forums) { this.categories = forums;
    }


}