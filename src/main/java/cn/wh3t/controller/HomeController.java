package cn.wh3t.controller;

import cn.wh3t.entity.Article;
import cn.wh3t.entity.HostHolder;
import cn.wh3t.entity.ViewObject;
import cn.wh3t.service.ArticleService;
import cn.wh3t.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SSM3
 * @author: CNWh3t
 * @create: 2019-01-14 20:45
 * @description:
 */
@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    @Autowired
    HostHolder hostHolder;

    /**
     * @author : CNWh3t
     * @DateTime : 2019/1/14 20:52
     * @Param : [userId]
     * @Rerturn : java.util.List<cn.wh3t.entity.Article>
     * @description : 如果登录显示全部，没登陆，只显示10条
     */


    @RequestMapping(path = {"/","/index"},method = {RequestMethod.POST,RequestMethod.GET})
    public String home(Model model,
                       @RequestParam(value = "pop",defaultValue = "0")int pop){
        List<Article> articlesList = articleService.getArticlesList();
        model.addAttribute("list",articlesList);
        if (null != hostHolder.getUser()){
            pop = 0;
        }
        model.addAttribute("pop",pop);
        return "home";
    }


    /*private List<ViewObject> getArticleList(){
        List<Article> articlesList = articleService.getArticlesList();
        return articlesList;
    }*/

}
