package tr.gov.ptt.gr2tahsilatuyg.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import tr.gov.ptt.gr2tahsilatuyg.entity.Menu;

@ManagedBean
@SessionScoped
public class MenuBean implements Serializable{
    
   
    private MenuModel menuModel ;
    
    @ManagedProperty(value ="#{kisiBean}" )
    private KisiBean kisiBean;
    
    public  MenuBean ()
    {
        menuModel =new DefaultMenuModel();
       
    }

    public void setKisiBean(KisiBean kisiBean) {
        this.kisiBean = kisiBean;
    }
    @PostConstruct
    public void initMenu()
    {
        DefaultSubMenu subMenu = new DefaultSubMenu("Menu İşlemleri");
       
        
        DefaultMenuItem menuItem ;
        List<Menu> menuListe = kisiBean.getKisi().getTip().getMenuList();
        for (Menu menu : menuListe) {
           menuItem = new DefaultMenuItem();
           menuItem.setValue(menu.getBaslik());
           menuItem.setCommand(menu.getLink());
           subMenu.addElement(menuItem);   
        }

        menuModel.addElement(subMenu);
        
        
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }
    
    
}
