package tr.gov.ptt.gr2tahsilatuyg.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.gr2tahsilatuyg.entity.Kisi;
import tr.gov.ptt.gr2tahsilatuyg.facade.KisiFacade;

@Stateless
public class KisiService {
  @EJB  
  private KisiFacade kisiFacade;
    
  public Kisi girisKontrol(Kisi p_kişi){
       
        return kisiFacade.girisKontrol(p_kişi);

    }   
  
  public void kisiGuncelle(Kisi p_kişi){
       
         kisiFacade.edit(p_kişi);
    }  
}
