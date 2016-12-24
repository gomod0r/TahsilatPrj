package tr.gov.gomodor.tahsilatprj.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.gomodor.tahsilatprj.entity.Borc;

@Stateless
public class BorcFacade extends AbstractFacade<Borc> {
    @PersistenceContext(unitName = "tr.gov.gomodor_TahsilatPrj_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BorcFacade() {
        super(Borc.class);
    }
    
    public List<Borc> borclariGetir(Integer p_kurumNo, String p_aboneNo){
        
        return em.createNamedQuery("Borc.kurumBorclariniGetir")
                            .setParameter("kurumNo", p_kurumNo)
                            .setParameter("aboneNo", p_aboneNo)
                            .getResultList();
        
    }
    
}
