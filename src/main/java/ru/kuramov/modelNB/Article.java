/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kuramov.modelNB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valerii
 */
@Entity (name = "ArticleEntity")
@Table(name = "ARTICLE_", catalog = "CATALOG_schema", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM ArticleEntity a"),
    @NamedQuery(name = "Article.findByIdArticle", query = "SELECT a FROM ArticleEntity a WHERE a.id = :idArticle"),
    @NamedQuery(name = "Article.findByTitle", query = "SELECT a FROM ArticleEntity a WHERE a.title = :title")})
public class Article extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    private Integer idArticle;
    @Size(max = 150)
    private String title;
    @JoinColumn(name = "Section_idSection", referencedColumnName = "idSection")
    @ManyToOne(optional = false)
    private Section sectionidSection;

    public Article() {
    }

    public Article(Long idArticle) {
        id = idArticle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idArticle) {
        id = idArticle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Section getSectionidSection() {
        return sectionidSection;
    }

    public void setSectionidSection(Section sectionidSection) {
        this.sectionidSection = sectionidSection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.kuramov.model.Article[ idArticle=" + id + " ]";
    }
    
}
