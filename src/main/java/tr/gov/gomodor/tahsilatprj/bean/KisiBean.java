package tr.gov.gomodor.tahsilatprj.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import tr.gov.gomodor.tahsilatprj.entity.Kisi;
import tr.gov.gomodor.tahsilatprj.service.KisiService;
import tr.gov.gomodor.util.JSFUtil;

@Named(value = "kisiBean")
@SessionScoped
public class KisiBean implements Serializable {

    //@ManagedProperty("#{msg}")
    //private ResourceBundle mesajlar;
    
    private Kisi kisi = new Kisi();
    
    @Inject
    private KisiService kisiService;
    
    public KisiBean() {
    }

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }
    
    public String girisKontrol(){
        
        ResourceBundle backendText = FacesContext.getCurrentInstance().getApplication().
                                     getResourceBundle(FacesContext.getCurrentInstance(), "msg");
        
        Kisi vtKisi = kisiService.girisKontrol(this.kisi);
        
        if (vtKisi != null) {
            
            this.kisi = vtKisi;
            
            HttpSession session = JSFUtil.getSession();
            session.setAttribute("kullanici", this.kisi.getKullaniciAd());
            
            return "menu.xhtml";
            
        } else {
            
            JSFUtil.hataGoster(backendText.getString("tahsilatprj.giris.loginErrorSummary"), 
                               backendText.getString("tahsilatprj.giris.loginErrorDetail"));
            
            return "giris.xhtml";
            
        }
 
        
    }
    
    public String guvenliCikis(){
        
        HttpSession session = JSFUtil.getSession();
        JSFUtil.sessionBitir(session);
        JSFUtil.mesajGoster("Session bitti.", "Yeniden Giriş Yapınız.");
        
        return "giris.xhtml?faces-redirect=true";
        
    }
    
}
