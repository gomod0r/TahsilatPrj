package tr.gov.gomodor.tahsilatprj.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import tr.gov.gomodor.tahsilatprj.facade.KisiFacade;

@Named
@SessionScoped
public class ThemeBean implements Serializable{
    
    private List<String> temaListesi;
    
    @Inject
    private KisiBean kisiBean;
    
    @Inject
    private KisiFacade kisiFacade;
    
    public ThemeBean() {
        
        temaListesi = new ArrayList<String>();
        
        temaListesi.add("blitzer");
        temaListesi.add("mint-choc");
        temaListesi.add("bluesky");
        temaListesi.add("afterdark");
        temaListesi.add("afternoon");
        temaListesi.add("vader");
        
    }

    public List<String> getTemaListesi() {
        return temaListesi;
    }

    public void setTemaListesi(List<String> temaListesi) {
        this.temaListesi = temaListesi;
    }
    
    public void temayiKaydet(){
        
        kisiFacade.edit(kisiBean.getKisi());
        
    }
    
}
