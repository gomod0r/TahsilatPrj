package tr.gov.gomodor.tahsilatprj.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tr.gov.gomodor.tahsilatprj.entity.Borc;
import tr.gov.gomodor.tahsilatprj.facade.BorcFacade;

@Stateless
public class BorcService {
    
    @Inject
    private BorcFacade borcFacade;
    
    public List<Borc> borclariGetir(Integer p_kurumNo, String p_aboneNo){
        
        return borcFacade.borclariGetir(p_kurumNo, p_aboneNo);
        
    }
    
}
