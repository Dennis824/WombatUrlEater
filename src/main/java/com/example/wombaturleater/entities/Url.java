package com.example.wombaturleater.entities;


import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "url")
public class Url {

    public Url() {
    }

    public Url(String longUrl) {
        this.longUrl = longUrl;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "long_url")
    private String longUrl;


//    @Column(name = "createdDate")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;

//    @Column(name = "shortUrl")
//    private String shortUrl;

//    @Transient
//    private boolean expired; // Hibernate will ignore this field. default false.

//    public String getShortUrl() {
//        return shortUrl;
//    }
//
//    public Url(String longUrl) {
//        this.longUrl = longUrl;
//    }
//
//    public void setShortUrl(String shortUrl) {
//        this.shortUrl = shortUrl;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }

}
