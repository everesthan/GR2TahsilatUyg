package tr.gov.ptt.gr2tahsilatuyg.bean;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import tr.gov.ptt.gr2tahsilatuyg.entity.Kisi;
import tr.gov.ptt.gr2tahsilatuyg.service.KisiService;
import tr.gov.ptt.gr2tahsilatuyg.util.JSFUtil;

@ManagedBean
@SessionScoped
public class KisiBean {
  
    private Kisi kisi;
    
    @EJB
    private KisiService kisiService;
    
    private List<String> temaListesi ;
    

    public KisiBean() {
       kisi = new Kisi();   
       kisi.setTema("bluesky");
       temaListesi =new ArrayList<>();
       
       temaListesiDoldur();
    }
 public void temaListesiDoldur()
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

    }
    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    public List<String> getTemaListesi() {
        return temaListesi;
    }

   
   
   
    
    public String girisKontrol(){
       Kisi vtKisi = kisiService.girisKontrol(kisi);
       
        if (vtKisi != null) 
        {
            this.kisi = vtKisi;
            HttpSession session = JSFUtil.getSession();
            session.setAttribute("username", vtKisi.getKullaniciAd());
            System.out.println("Girişteki"+kisi.getTema());
           
            return "menu.xhtml?faces-redirect=true";
        }
        else{
            JSFUtil.hataMesajiekle("Yanliş Giriş: ", "Kullanıcı adı ya da Şifre yanlış!");
            return "giris.xhtml?faces-redirect=true";
        }
        
    }
  public String guvenliCikis(){
        JSFUtil.sessionBitir();
         return "giris.xhtml?faces-redirect=true"  ;
    }         
   public void temaKaydet()
   {
       kisiService.kisiGuncelle(kisi);
   }
    
}
