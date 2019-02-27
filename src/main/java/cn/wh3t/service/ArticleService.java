package cn.wh3t.service;

import cn.wh3t.entity.Article;

import java.util.List;

/**
 * @program: SSM3
 * @author: CNWh3t
 * @create: 2019-01-13 17:30
 * @description:
 */

public interface ArticleService {

    List<Article> getArticlesList();

    int getListCount();
}
