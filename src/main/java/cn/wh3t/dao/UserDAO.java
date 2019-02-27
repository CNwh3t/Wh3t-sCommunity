package cn.wh3t.dao;

import cn.wh3t.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: Wh3tsNews
 * @author: CNWh3t
 * @create: 2019-01-10 18:48
 * @description:
 */

public interface UserDAO {

    User selectUserById(int id);

    List<User> selectUsersByName(String userName);

    User selectUserByName(String userName);

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(int id);

    User selectUserByNameAndPwd(@Param("userName") String userName,
                                @Param("userPassword") String userPassword);
}
