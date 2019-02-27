package cn.wh3t.dao;

import cn.wh3t.entity.LoginTicket;
import org.apache.ibatis.annotations.Param;

/**
 * @program: Toutiao
 * @author: CNWh3t
 * @create: 2019-01-18 11:41
 * @description:
 */

public interface LoginTicketDAO {

    void addTicket(LoginTicket loginTicket);

    LoginTicket selectByTicket(String ticket);

    void updateTicket(@Param("ticket")String ticket,@Param("status")int status);
}
