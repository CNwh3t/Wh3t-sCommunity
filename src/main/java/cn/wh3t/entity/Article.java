package cn.wh3t.entity;

import java.util.Date;

/**
 * @program: Wh3tsNews
 * @author: CNWh3t
 * @create: 2019-01-10 20:44
 * @description:
 */

public class Article {

    private int id;
    private User user;
    private String title;
    private String image;
    private String content;
    private Date pubulishTime;
    private String author;
    private String link;
    private String localName;


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                ", pubulishTime=" + pubulishTime +
                ", link=" + link +
                ", localName=" + localName +
                '}';
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubulishTime() {
        return pubulishTime;
    }

    public void setPubulishTime(Date pubulishTime) {
        this.pubulishTime = pubulishTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}