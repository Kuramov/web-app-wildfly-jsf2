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
@Entity (name = "CatalogEntity")
@Table(name = "CATALOG_", catalog = "CATALOG_schema", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalog.findAll", query = "SELECT c FROM CatalogEntity c"),
    @NamedQuery(name = "Catalog.findByIdCatalog", query = "SELECT c FROM CatalogEntity c WHERE c.idCatalog = :idCatalog"),
    @NamedQuery(name = "Catalog.findByJornal", query = "SELECT c FROM CatalogEntity c WHERE c.jornal = :jornal")})
public class Catalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idCatalog;
    @Size(max = 100)
    private String jornal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogidCatalog")
    private List<Edition> editionList;

    public Catalog() {
    }

    public Catalog(Integer idCatalog) {
        this.idCatalog = idCatalog;
    }

    public Integer getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(Integer idCatalog) {
        this.idCatalog = idCatalog;
    }

    public String getJornal() {
        return jornal;
    }

    public void setJornal(String jornal) {
        this.jornal = jornal;
    }

    @XmlTransient
    public List<Edition> getEditionList() {
        return editionList;
    }

    public void setEditionList(List<Edition> editionList) {
        this.editionList = editionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatalog != null ? idCatalog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalog)) {
            return false;
        }
        Catalog other = (Catalog) object;
        if ((this.idCatalog == null && other.idCatalog != null) || (this.idCatalog != null && !this.idCatalog.equals(other.idCatalog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.kuramov.model.Catalog[ idCatalog=" + idCatalog + " ]";
    }
    
}
