package com.example.wombaturleater.entities;




import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "link")
public class Link {

    public Link() {
    }

    public Link(String longLink) {
        this.longLink = longLink;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "long_link")
    private String longLink;



    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "short_link")
    private String shortLink;

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }
//    @Transient
//    private boolean expired; // Hibernate will ignore this field. default false.



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLongLink() {
        return longLink;
    }

    public void setLongLink(String longLink) {
        this.longLink = longLink;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
