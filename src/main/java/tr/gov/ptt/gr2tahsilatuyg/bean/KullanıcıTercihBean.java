package tr.gov.ptt.gr2tahsilatuyg.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import tr.gov.ptt.gr2tahsilatuyg.service.KisiService;

@ManagedBean(name = "tercih")
@SessionScoped
public class KullanıcıTercihBean implements Serializable
{
    private List<String> temaListesi ;
    
    @ManagedProperty(value = "#{kisiBean}")
    private KisiBean kisiBean;
    
    private String seciliTema;
    
    @EJB
    private KisiService kisiService;
    
    public KullanıcıTercihBean() 
    {
       temaListesi = new ArrayList<String>();
       temaListesi.add("afterdark");
       temaListesi.add("blitzer");
       temaListesi.add("hot-sneaks");
       temaListesi.add("humanity");
       temaListesi.add("south-street");
       temaListesi.add("sunny");
       temaListesi.add("trontastic");
       temaListesi.add("vader");
       
       seciliTema = "afterdark";
       
       
       
  
    }
    @PostConstruct
    public void vtTemaCek(){
        System.out.println(kisiBean);
            seciliTema = kisiBean.getKisi().getTema();
            System.out.println(kisiBean.getKisi().getKullaniciAd()); 
            
                 
                    
            System.out.println("seciliTema"+ seciliTema);  
                      
                    
            if(seciliTema== null || seciliTema.equals(""))
                seciliTema ="bluesky";
      
    }

    public KisiBean getKisiBean() {
        return kisiBean;
    }
            
            
    public List<String> getTemaListesi()
    {
        return temaListesi;
    }

    public void setKisiBean(KisiBean kisiBean) {
        this.kisiBean = kisiBean;
    }

    public String getSeciliTema() {
        return seciliTema;
    }

    public void setSeciliTema(String seciliTema) {
        this.seciliTema = seciliTema;
    }
    
    
    public void temaKaydet()
    {
        kisiBean.getKisi().setTema(seciliTema);
        kisiService.kisiGuncelle(kisiBean.getKisi());
        
    }
    
}
