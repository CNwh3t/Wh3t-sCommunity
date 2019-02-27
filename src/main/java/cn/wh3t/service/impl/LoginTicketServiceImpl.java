package cn.wh3t.service.impl;

import cn.wh3t.dao.LoginTicketDAO;
import cn.wh3t.entity.LoginTicket;
import cn.wh3t.service.LoginTicketService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: Toutiao
 * @author: CNWh3t
 * @create: 2019-01-18 11:53
 * @description:
 */

public class LoginTicketServiceImpl implements LoginTicketService {

    @Autowired
    LoginTicketDAO loginTicketDAO;

    @Override
    public void addLoginTicket(LoginTicket loginTicket) {
        loginTicketDAO.addTicket(loginTicket);
    }

    @Override
    public LoginTicket selectByTicket(String ticket) {
        return loginTicketDAO.selectByTicket(ticket);
    }

    @Override
    public void updateTicket(String ticket, int status) {
        loginTicketDAO.updateTicket(ticket,status);
    }
}
