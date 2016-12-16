package ru.kuramov.data;

import ru.kuramov.daoNB.ArticleFacade;
import ru.kuramov.modelNB.Article;
import ru.kuramov.model.Member;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by valerii on 15.12.16.
 */

@RequestScoped
public class ArticleListProducer {

    @Inject
    //private MemberRepository memberRepository;
    private ArticleFacade articleFacade;

    private List<Article> articles;

    // @Named provides access the return value via the EL variable name "catalogs" in the UI (e.g.
    // Facelets or JSP view)
    @Produces
    @Named
    public List<Article> getArticles() {
        return articles;
    }

    @Produces
    @Named
    public int getArticlesCount() {
        return articles.size();
    }

    public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Member member) {
        retrieveAllMembersOrderedByName();
    }

    @PostConstruct
    public void retrieveAllMembersOrderedByName() {
        articles = articleFacade.findAll();
    }
}
