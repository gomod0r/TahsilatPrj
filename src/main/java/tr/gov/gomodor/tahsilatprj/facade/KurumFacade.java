package tr.gov.gomodor.tahsilatprj.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.gomodor.tahsilatprj.entity.Kurum;

@Stateless
public class KurumFacade extends AbstractFacade<Kurum> {
    @PersistenceContext(unitName = "tr.gov.gomodor_TahsilatPrj_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KurumFacade() {
        super(Kurum.class);
    }
    
    public List<String> kurumAdlariniGetir(){
        
        return em.createQuery("select k.ad from Kurum k order by k.ad").getResultList();
        
    }
    
    public Integer kurumAdIleNoGetir(String p_kurumAdi){
        
        Integer kurumNo = (Integer) em.createQuery("SELECT k.no FROM Kurum k WHERE k.ad = :ad")
                .setParameter("ad", p_kurumAdi)
                .getSingleResult();
        
        return kurumNo;
        
    }   
    
}
