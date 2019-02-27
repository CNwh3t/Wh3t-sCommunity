package cn.wh3t.service;

import cn.wh3t.entity.LoginTicket;

/**
 * @program: Toutiao
 * @author: CNWh3t
 * @create: 2019-01-18 11:52
 * @description:
 */

public interface LoginTicketService {

    void addLoginTicket(LoginTicket loginTicket);

    LoginTicket selectByTicket(String ticket);

    void updateTicket(String ticket,int status);

}
