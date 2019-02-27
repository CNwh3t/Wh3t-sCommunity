package cn.wh3t.entity;

import java.util.Date;

/**
 * @program: Toutiao
 * @author: CNWh3t
 * @create: 2019-01-18 11:34
 * @description: 登陆凭证
 */

public class LoginTicket {

    private int id;
    private int userId;
    private Date expired;   //有效时间
    private int status;
    private String ticket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
