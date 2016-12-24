/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.gomodor.tahsilatprj.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.gomodor.tahsilatprj.entity.Tahsilat;

/**
 *
 * @author toshıba
 */
@Stateless
public class TahsilatFacade extends AbstractFacade<Tahsilat> {
    @PersistenceContext(unitName = "tr.gov.gomodor_TahsilatPrj_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TahsilatFacade() {
        super(Tahsilat.class);
    }
    
}
