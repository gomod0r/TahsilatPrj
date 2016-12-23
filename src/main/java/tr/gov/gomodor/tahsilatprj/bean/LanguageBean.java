package tr.gov.gomodor.tahsilatprj.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.context.FacesContext;

@Named(value = "languageBean")
@SessionScoped
public class LanguageBean implements Serializable {
    
    private String localeCode;
    
    private static Map<String, Object> ulkeler;
    static{
        
        ulkeler = new LinkedHashMap<String, Object>();
        ulkeler.put("Türkçe", new Locale("tr","TR"));
        ulkeler.put("English", Locale.ENGLISH);
                
    }
    
    public LanguageBean() {
        
    }

    public Map<String, Object> getUlkeler() {
        return ulkeler;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }
    
    public void yeniDilSecildiginde(){
        
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(localeCode));
        
    }
    
}
