/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kuramov.daoNB;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.kuramov.modelNB.Section;
import ru.kuramov.util.QualifierCatalog_PU;

/**
 *
 * @author valerii
 */
@Stateless
public class SectionFacade extends AbstractFacade<Section> {

    @Inject
    @QualifierCatalog_PU
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SectionFacade() {
        super(Section.class);
    }
    
}
