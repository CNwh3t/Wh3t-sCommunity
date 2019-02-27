package cn.wh3t.dao;

import cn.wh3t.entity.Article;

import java.util.List;

/**
 * @program: Wh3tsNews
 * @author: CNWh3t
 * @create: 2019-01-10 21:14
 * @description:
 */

public interface ArticleDAO {

    List<Article> getUserArticlesFir(int id);

    List<Article> getUserArticlesSec(int id);

    //展示当前全部news
    List<Article> getArticlesList();

    int getListCount();
}
