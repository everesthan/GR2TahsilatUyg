package tr.gov.ptt.gr2tahsilatuyg.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.gr2tahsilatuyg.entity.Borc;


@Stateless
public class BorcFacade extends AbstractFacade<Borc> {
    @PersistenceContext(unitName = "tr.gov.ptt_GR2TahsilatUyg_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BorcFacade() {
        super(Borc.class);
    }
     
    
    public List<Borc> borclariGetir(Borc p_borc)
    {
       List<Borc> borcListesi =  em.createNamedQuery("Borc.findByKurumIdAboneNo")
                .setParameter("kurumId", p_borc.getKurum().getId())
                .setParameter("aboneNo", p_borc.getAboneNo()).getResultList();
                
        
        return borcListesi;
    } 
}
