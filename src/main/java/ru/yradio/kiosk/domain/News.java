package ru.yradio.kiosk.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * News entity
 *
 * @author k.boenko
 * @since 27.03.17.
 *
 */
@Entity
@Table(name = "news")
public class News {
    private Long id;
    private String head;
    private String body;
    private Date date;
    private byte[] picture;

    /**
    *
     * Set creation date in constructor
     */
    public News() {
        this.date = new Date();
    }

    /**
     *
     * News id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * News head
     */
    @Column(name = "head")
    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    /**
     *
     * News body
     */
    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    /**
     *
     * News creation date (timestamp)
     */
    @Column(name = "date_news")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    /**
     *
     * News picture
     */
    @Column(name = "picture")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
