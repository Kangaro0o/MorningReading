package com.mr.mybatis.dto;

import com.mr.mybatis.bo.Article;

/**
 * @author LiuWen
 * @date 2019-12-19 20:42
 */
public class MaterialListResult {
    Article articles;

    String date;

    public Article getArticles() {
        return articles;
    }

    public void setArticles(Article articles) {
        this.articles = articles;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
