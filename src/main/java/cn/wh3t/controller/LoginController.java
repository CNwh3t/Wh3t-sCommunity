package cn.wh3t.controller;

import cn.wh3t.entity.User;
import cn.wh3t.service.UserService;
import cn.wh3t.util.ToutiaoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @program: Toutiao
 * @author: CNWh3t
 * @create: 2019-01-18 11:27
 * @description: 登陆控制器
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @RequestMapping(path = "/reg/",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String register(Model model, @RequestParam("username")String userName,
                           @RequestParam("password")String userPassword,
                           @RequestParam(value = "rember",defaultValue = "0")int remberme,
                           HttpServletResponse response){
        try {
            Map<String, Object> map = userService.addUser(userName, userPassword);
            if (map.containsKey("ticket")){
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("/");
                if (remberme>0){
                    //三天之内记住账号密码
                    cookie.setMaxAge(3600*24*3);
                }
                response.addCookie(cookie);
                /*邮件通知功能。。*/
                return ToutiaoUtil.getJSONString(0,"注册成功");
            }else{
                return ToutiaoUtil.getJSONString(1,map);
            }
        } catch (Exception e) {
            logger.error("注册异常"+e.getMessage());
            return ToutiaoUtil.getJSONString(1,"注册异常");
        }


    }

    @RequestMapping(path = {"/login/"},method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public  String  login(Model model, @RequestParam("username")String userName,
                          @RequestParam("password")String userPassword,
                          @RequestParam(value = "rember",defaultValue = "0")int remberme,
                          HttpServletResponse response){
        try {
            Map<String, Object> map = userService.login(userName, userPassword);
            if (map.containsKey("ticket")){
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("/");
                if (remberme>0){
                    //三天之内记住账号密码
                    cookie.setMaxAge(3600*24*3);
                }
                response.addCookie(cookie);
                return ToutiaoUtil.getJSONString(0,"登陆成功");
            }else{
                return ToutiaoUtil.getJSONString(1,map);
            }
        } catch (Exception e) {
            logger.error("登陆异常"+e.getMessage());
            return ToutiaoUtil.getJSONString(1,"登陆异常");
        }
    }

    @RequestMapping(path = {"/logout"},method = {RequestMethod.POST,RequestMethod.GET})
    public String logout(@CookieValue("ticket")String ticket){
        userService.logout(ticket);
        return "redirect:/";
    }
}
