package cn.wh3t.service.impl;

import cn.wh3t.dao.ArticleDAO;
import cn.wh3t.entity.Article;
import cn.wh3t.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SSM3
 * @author: CNWh3t
 * @create: 2019-01-13 17:30
 * @description:
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDAO articleDAO;

    @Override
    public List<Article> getArticlesList() {
        return articleDAO.getArticlesList();
    }

    public int getListCount(){
        return articleDAO.getListCount();
    }
}
