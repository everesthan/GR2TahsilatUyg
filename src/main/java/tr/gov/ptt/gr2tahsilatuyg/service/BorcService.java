
package tr.gov.ptt.gr2tahsilatuyg.service;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.gr2tahsilatuyg.entity.Borc;
import tr.gov.ptt.gr2tahsilatuyg.facade.BorcFacade;
import tr.gov.ptt.gr2tahsilatuyg.facade.KisiFacade;
import tr.gov.ptt.gr2tahsilatuyg.facade.KurumFacade;

@Stateless
public class BorcService {
    
    
    @EJB
    private BorcFacade borcFacade ;
    
    @EJB
    private KurumFacade kurumFacade;
    
     public List<Borc> borclariGetir(Borc p_borc)
    {
        int kid = kurumFacade.kurumIdGetir(p_borc.getKurum().getAd());
        p_borc.getKurum().setId(new BigDecimal(kid));
        return borcFacade.borclariGetir(p_borc);
    } 
    
     public List<String> tamamlaKurumAdi(String p_sorgu){
         
     return kurumFacade.tamamlaKurumAdi(p_sorgu);
     }
     
    public int kurumIdGetir(String p_kurumAd)
    {
        return kurumFacade.kurumIdGetir(p_kurumAd);
    }
}
