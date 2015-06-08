package tr.gov.ptt.gr2tahsilatuyg.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tr.gov.ptt.gr2tahsilatuyg.entity.Borc;
import tr.gov.ptt.gr2tahsilatuyg.service.BorcService;

@ManagedBean
@RequestScoped
public class BorcBean {
    private Borc borc;
    
    private List<Borc> borcListesi;
    
    @EJB
    private BorcService borcService;

    public BorcBean(Borc borc) {
        borc = new Borc();
        borcListesi = new ArrayList<Borc>();
    }

    public Borc getBorc() {
        return borc;
    }

    public void setBorc(Borc borc) {
        this.borc = borc;
    }
    
    
    public String borclistele()
    {
        borcListesi = borcService.borclariGetir(borc);
        return "tahsilatListele.xhtml?faces-redirect=true";
                
    }
    
 
            
}
