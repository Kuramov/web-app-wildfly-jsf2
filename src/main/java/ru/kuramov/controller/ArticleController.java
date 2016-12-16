package ru.kuramov.controller;

import ru.kuramov.daoNB.ArticleFacade;
import ru.kuramov.modelNB.Article;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Created by valerii on 16.12.16.
 */
@Model
public class ArticleController {

    @Inject
    private ArticleFacade articleFacade;

    private Long idArticle;

    private Article article;

    public String findArticle(long id) {

        this.article = articleFacade.find(id);

        return "articleOutput";
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public Article getArticle() {
        return article;
    }
}
