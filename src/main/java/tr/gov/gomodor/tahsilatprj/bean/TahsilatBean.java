package tr.gov.gomodor.tahsilatprj.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import tr.gov.gomodor.tahsilatprj.entity.Borc;
import tr.gov.gomodor.tahsilatprj.entity.Tahsilat;
import tr.gov.gomodor.tahsilatprj.service.BorcService;
import tr.gov.gomodor.tahsilatprj.service.KurumService;

@Named(value = "tahsilatBean")
@ViewScoped
public class TahsilatBean implements Serializable{
    
    private Tahsilat tahsilat = new Tahsilat();
    
    private Borc borc = new Borc();
    
    private List<Borc> kurumFaturaListesi = new ArrayList<Borc>();
    
    @Inject
    private KurumService kurumService;
    
    @Inject
    private BorcService borcService;
    
    public TahsilatBean() {
        
    }

    public List<Borc> getKuruFaturaListesi() {
        return kurumFaturaListesi;
    }

    public void setKuruFaturaListesi(List<Borc> kuruFaturaListesi) {
        this.kurumFaturaListesi = kuruFaturaListesi;
    }

    public Borc getBorc() {
        return borc;
    }

    public void setBorc(Borc borc) {
        this.borc = borc;
    }

    public Tahsilat getTahsilat() {
        return tahsilat;
    }

    public void setTahsilat(Tahsilat tahsilat) {
        this.tahsilat = tahsilat;
    }
    
    public List<String> kurumAdiTamamla(String p_sorgu){
        
        List<String> kurumAdiListe = kurumService.kurumAdlariniGetir();
        List<String> sonucListe = new ArrayList<String>();
        
        for (String kurumAdi : kurumAdiListe) {
            
            if (kurumAdi.toUpperCase(new Locale("tr","TR"))
                        .startsWith(p_sorgu.toUpperCase(new Locale("tr","TR")))) {
                
                sonucListe.add(kurumAdi);
                
            }
            
        }
        
        return sonucListe;
        
    }
    
    public String borcSorgula(){
        
        tahsilat.getKurum().setNo(kurumService.kurumAdIleNoGetir(tahsilat.getKurum().getAd()));
        
        kurumFaturaListesi = borcService.borclariGetir(tahsilat.getKurum().getNo(), borc.getAboneNo());
        
        return "tahsilatListele.xhtml?faces-redirect=true";
        
    }
    
}
