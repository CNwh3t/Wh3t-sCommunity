package cn.wh3t.controller;

import cn.wh3t.entity.Article;
import cn.wh3t.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: SSM3
 * @author: CNWh3t
 * @create: 2019-01-13 17:31
 * @description:
 */
@Controller
@RequestMapping(path = "/page")
public class ArticleController {

    private int lastPage;
    private int pageRows;

    @Autowired
    ArticleService articleService;

    private int getLastPage(){
        pageRows = 10;
        int count = articleService.getListCount();
        if (0 != count){
            if (count % pageRows != 0){
                lastPage = (count / pageRows +1);
            }else {
                lastPage = (count / pageRows);
            }
            System.out.println(lastPage+"页");
            return lastPage;
        }else {
            return 0;
        }
    }


    /**
     * @author : CNWh3t
     * @DateTime : 2019/1/16 10:19
     * @Param : [model]
     * @Rerturn : java.lang.String
     * @description : 第一页显示 10条
     */
    @RequestMapping(path = {"/1sss"})
    public String articleList01(){
        return "forward:/1";
    }

    @RequestMapping(path = {"/2xx"})
    public String articleList02(Model model){
        PageHelper.startPage(2,10);
        List<Article> list = articleService.getArticlesList();
        model.addAttribute("list",list);


        if (null!=list){
            PageInfo<Article> pageInfo = new PageInfo<>(list);
            long total = pageInfo.getTotal();
            System.out.println("共有"+total+"条信息。");
            return "home";
        }
        return "error";
    }

    @RequestMapping(path = {"/{id}x"})
    public String articleListByPage0(Model model, @PathVariable int id){
        int pageSzie = 10;
        PageHelper.startPage(id,pageSzie);
        List<Article> list = articleService.getArticlesList();
        model.addAttribute("list",list);

        if (null!=list){
            //return "forward:/index.jsp";
            PageInfo<Article> pageInfo = new PageInfo<>(list);
            long total = pageInfo.getTotal();
            System.out.println("共有"+total+"条信息。");
            model.addAttribute("id",id);
            int lastPage;
            if (total % pageSzie != 0){
                lastPage = (int) (total / pageSzie +1);
            }else {
                lastPage = (int) (total / pageSzie);
            }
            model.addAttribute("lastPage",lastPage);
            return "home";
        }
        return "error";
    }

    @RequestMapping(path = {"/{id}"})
    public String articleListByPage(Model model, @PathVariable String Id){
        lastPage = getLastPage();
        int id = Integer.valueOf(Id);
        if (id >= 1 && id <= lastPage){
            PageHelper.startPage(id,pageRows);
            List<Article> list = articleService.getArticlesList();
            model.addAttribute("list",list);
            model.addAttribute("lastPage",lastPage);

            return "home";
        }
        return "error";
    }
}
