package tr.gov.gomodor.tahsilatprj.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import tr.gov.gomodor.tahsilatprj.entity.Menu;
import tr.gov.gomodor.tahsilatprj.facade.MenuFacade;

@Named
@SessionScoped
public class MenuBean implements Serializable{
    
    @Inject
    private KisiBean kisiBean;
    
    @Inject
    private MenuFacade menuFacade;
    
    private DefaultMenuModel menuModel;

    public MenuBean() {
        
        menuModel = new DefaultMenuModel();
        
    }
    
    @PostConstruct
    public void menuDoldur(){
        
        List<Menu> ustMenuListesi = kisiBean.getKisi().getTip().getMenuList();
        
        for (Menu ustMenu : ustMenuListesi) {
            
            DefaultSubMenu subMenu = new DefaultSubMenu(ustMenu.getBaslik());
            
            List<Menu> altMenuListesi = menuFacade.altMenuleriGetir(ustMenu.getNo());
            
            for (Menu menu : altMenuListesi) {
                
                DefaultMenuItem menuItem = new DefaultMenuItem(menu.getBaslik());
                menuItem.setCommand(menu.getLink());
                menuItem.setIcon(menu.getIcon());
                subMenu.addElement(menuItem);
                
            }
            
            menuModel.addElement(subMenu);
            
        }
    
    }
    
    public MenuModel getModel(){
        
        return menuModel;
        
    }
    
}
