package cn.wh3t.entity;

import org.springframework.stereotype.Component;

/**
 * @program: Toutiao
 * @author: CNWh3t
 * @create: 2019-01-18 17:23
 * @description:
 */
@Component
public class HostHolder {

    private static ThreadLocal<User> users = new ThreadLocal<>();

    public User getUser(){
        return users.get();
    }

    public void setUsers(User user){
        users.set(user);
    }

    public void clear(){
        users.remove();
    }
}

