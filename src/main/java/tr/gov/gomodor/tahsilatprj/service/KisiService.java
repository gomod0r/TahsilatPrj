package tr.gov.gomodor.tahsilatprj.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import tr.gov.gomodor.tahsilatprj.entity.Kisi;
import tr.gov.gomodor.tahsilatprj.facade.KisiFacade;

@Stateless
public class KisiService {
    
    @Inject
    private KisiFacade kisiFacade;
    
    public Kisi girisKontrol(Kisi p_kisi){
        
        return kisiFacade.girisKontrol(p_kisi);
        
    }
    
}
