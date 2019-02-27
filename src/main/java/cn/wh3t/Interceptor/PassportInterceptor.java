package cn.wh3t.Interceptor;

import cn.wh3t.dao.LoginTicketDAO;
import cn.wh3t.dao.UserDAO;
import cn.wh3t.entity.HostHolder;
import cn.wh3t.entity.LoginTicket;
import cn.wh3t.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @program: Toutiao
 * @author: CNWh3t
 * @create: 2019-01-18 17:27
 * @description:
 */

public class PassportInterceptor implements HandlerInterceptor {

    @Autowired
    LoginTicketDAO loginTicketDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
        String ticket = null;
        if (null != httpServletRequest.getCookies()){
            for (Cookie cookie : httpServletRequest.getCookies()){
                System.out.println("this is request-----"+cookie.getName()+"---"+cookie.getValue());
                if (cookie.getName().equals("ticket")){
                    ticket = cookie.getValue();
                    break;
                }
            }
        }
        System.out.println("this is console--"+ticket);
        if (null != ticket){
            LoginTicket loginTicket = loginTicketDAO.selectByTicket(ticket);
            if (null == loginTicket || loginTicket.getExpired().before(new Date()) ||
                    loginTicket.getStatus() != 0){
                return true;
            }
            User user = userDAO.selectUserById(loginTicket.getUserId());
            hostHolder.setUsers(user);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
        if (null != modelAndView && null != hostHolder.getUser()){
            modelAndView.addObject("user",hostHolder.getUser());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o,
                                Exception e) throws Exception {
        hostHolder.clear();

    }
}
