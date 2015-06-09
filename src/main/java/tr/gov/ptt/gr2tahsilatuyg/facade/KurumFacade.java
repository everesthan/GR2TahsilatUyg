package tr.gov.ptt.gr2tahsilatuyg.facade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.gr2tahsilatuyg.entity.Borc;
import tr.gov.ptt.gr2tahsilatuyg.entity.Kurum;


@Stateless
public class KurumFacade extends AbstractFacade<Kurum> {
    @PersistenceContext(unitName = "tr.gov.ptt_GR2TahsilatUyg_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KurumFacade() {
        super(Kurum.class);
    }
    
public int kurumIdGetir(String p_kurumAd)
{
  Kurum kurum = (Kurum)em.createNamedQuery("Kurum.findByAd")
          .setParameter("ad", p_kurumAd)
          .getSingleResult();
  
  return kurum.getId().intValue();
    
    
}
 public List<String> tamamlaKurumAdi(String p_sorgu){
     
     List<String> kurumAdiListesi=new ArrayList<String>();
     List<Kurum> kurumListesi = findAll();
     
     for (Kurum kurum : kurumListesi) {
         if(kurum.getAd().toUpperCase().startsWith(p_sorgu.toUpperCase())){
             kurumAdiListesi.add(kurum.getAd());
         }
         
     }
     return kurumAdiListesi;
 }       
    
}
