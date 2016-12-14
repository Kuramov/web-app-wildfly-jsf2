/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kuramov.modelNB;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author valerii
 */
@Entity (name = "SectionEntity")
@Table(name = "SECTION_", catalog = "CATALOG_schema", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Section.findAll", query = "SELECT s FROM SectionEntity s"),
    @NamedQuery(name = "Section.findByIdSection", query = "SELECT s FROM SectionEntity s WHERE s.idSection = :idSection"),
    @NamedQuery(name = "Section.findBySectionname", query = "SELECT s FROM SectionEntity s WHERE s.sectionname = :sectionname")})
public class Section implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idSection;
    @Size(max = 50)
    private String sectionname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sectionidSection")
    private List<Article> articleList;
    @JoinColumn(name = "Edition_idEdition", referencedColumnName = "idEdition")
    @ManyToOne(optional = false)
    private Edition editionidEdition;

    public Section() {
    }

    public Section(Integer idSection) {
        this.idSection = idSection;
    }

    public Integer getIdSection() {
        return idSection;
    }

    public void setIdSection(Integer idSection) {
        this.idSection = idSection;
    }

    public String getSectionname() {
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }

    @XmlTransient
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public Edition getEditionidEdition() {
        return editionidEdition;
    }

    public void setEditionidEdition(Edition editionidEdition) {
        this.editionidEdition = editionidEdition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSection != null ? idSection.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Section)) {
            return false;
        }
        Section other = (Section) object;
        if ((this.idSection == null && other.idSection != null) || (this.idSection != null && !this.idSection.equals(other.idSection))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.kuramov.model.Section[ idSection=" + idSection + " ]";
    }
    
}
