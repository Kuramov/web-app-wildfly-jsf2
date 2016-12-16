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
@Entity (name = "EditionEntity")
@Table(name = "EDITION_",catalog = "CATALOG_schema", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edition.findAll", query = "SELECT e FROM EditionEntity e"),
    @NamedQuery(name = "Edition.findByIdEdition", query = "SELECT e FROM EditionEntity e WHERE e.idEdition = :idEdition"),
    @NamedQuery(name = "Edition.findByEdition", query = "SELECT e FROM EditionEntity e WHERE e.edition = :edition")})
public class Edition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idEdition;
    @Size(max = 100)
    private String edition;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "editionidEdition")
    private List<Section> sectionList;
    @JoinColumn(name = "Catalog_idCatalog", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Catalog catalogidCatalog;

    public Edition() {
    }

    public Edition(Integer idEdition) {
        this.idEdition = idEdition;
    }

    public Integer getIdEdition() {
        return idEdition;
    }

    public void setIdEdition(Integer idEdition) {
        this.idEdition = idEdition;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @XmlTransient
    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public Catalog getCatalogidCatalog() {
        return catalogidCatalog;
    }

    public void setCatalogidCatalog(Catalog catalogidCatalog) {
        this.catalogidCatalog = catalogidCatalog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEdition != null ? idEdition.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edition)) {
            return false;
        }
        Edition other = (Edition) object;
        if ((this.idEdition == null && other.idEdition != null) || (this.idEdition != null && !this.idEdition.equals(other.idEdition))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.kuramov.model.Edition[ idEdition=" + idEdition + " ]";
    }
    
}
