package cn.wh3t.service.impl;

import cn.wh3t.dao.LoginTicketDAO;
import cn.wh3t.dao.UserDAO;
import cn.wh3t.entity.LoginTicket;
import cn.wh3t.entity.User;
import cn.wh3t.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @program: SSM3
 * @author: CNWh3t
 * @create: 2019-01-12 21:45
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    LoginTicketDAO loginTicketDAO;

    @Override
    public Map<String,Object> addUser(String userName,String userPassword) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isBlank(userName)){
            map.put("msgName","用户名不能为空");
            return map;
        }
        if (StringUtils.isBlank(userPassword)){
            map.put("msgPwd","密码不能为空");
            return map;
        }
        User user = userDAO.selectUserByName(userName);
        if (null != user){
            map.put("msgUser","用户名已存在");
            return map;
        }
        user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setGender(1);
        user.setImage("href"+Math.random());
        Date date = new Date();
        user.setCreateTime(date);
        userDAO.addUser(user);

        System.out.println("新增的user的id："+user.getId());

        String ticket = addTicket(user.getId());
        map.put("ticket",ticket);
        return map;
    }

    @Override
    public Map<String, Object> login(String userName, String userPassword) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isBlank(userName)){
            map.put("msgName","用户名不能为空");
            return map;
        }
        if (StringUtils.isBlank(userPassword)){
            map.put("msgPwd","密码不能为空");
            return map;
        }
        User user = userDAO.selectUserByNameAndPwd(userName, userPassword);
        if (null == user){
            map.put("msgUser","用户名不存在或者密码不正确");
            return map;
        }

        map.put("userId",user.getId());

        String ticket = addTicket(user.getId());
        map.put("ticket",ticket);
        return map;
    }

    @Override
    public void logout(String ticket) {
        loginTicketDAO.updateTicket(ticket,1);
    }


    private String addTicket(int userId){
        LoginTicket ticket = new LoginTicket();
        ticket.setUserId(userId);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));
        Date date = new Date();
        date.setTime(date.getTime()+1000*3600*24);
        ticket.setExpired(date);
        ticket.setStatus(0);
        loginTicketDAO.addTicket(ticket);
        return ticket.getTicket();
    }
}
