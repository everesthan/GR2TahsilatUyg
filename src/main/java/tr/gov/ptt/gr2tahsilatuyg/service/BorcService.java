
package tr.gov.ptt.gr2tahsilatuyg.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.gr2tahsilatuyg.entity.Borc;
import tr.gov.ptt.gr2tahsilatuyg.facade.BorcFacade;

@Stateless
public class BorcService {
    
    
    @EJB
    private BorcFacade borcFacade ;
    
     public List<Borc> borclariGetir(Borc p_borc)
    {
        return borcFacade.borclariGetir(p_borc);
    } 
    
    
    
}
