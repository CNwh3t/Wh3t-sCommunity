package cn.wh3t.service;

import cn.wh3t.entity.User;

import java.util.Map;

/**
 * @program: SSM3
 * @author: CNWh3t
 * @create: 2019-01-12 21:20
 * @description:
 */

public interface UserService {

    Map<String, Object> addUser(String userName,String userPassword);

    Map<String, Object> login(String userName, String userPassword);

    void logout(String ticket);
}
