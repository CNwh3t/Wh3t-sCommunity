package cn.wh3t.controller;

import cn.wh3t.entity.HostHolder;
import cn.wh3t.entity.LoginTicket;
import cn.wh3t.entity.User;
import cn.wh3t.service.LoginTicketService;
import cn.wh3t.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;


/**
 * @program: SSM3
 * @author: CNWh3t
 * @create: 2019-01-12 21:44
 * @description:
 */

@Controller
@RequestMapping(path = {"/user"})
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    HostHolder hostHolder;



    @RequestMapping(path = {"/{id}"},method = {RequestMethod.POST,RequestMethod.GET})
    public String checkInfo(Model model,
                            @PathVariable("id")int userId){

        if (null != hostHolder.getUser()){
            User user = hostHolder.getUser();
            if (user.getId() == userId){
                model.addAttribute("user",user);
                return "userInfo";
            }
            return "error";
        }
        return "redirect:/";

    }





}

