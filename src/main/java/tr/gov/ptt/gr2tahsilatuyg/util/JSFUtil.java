
package tr.gov.ptt.gr2tahsilatuyg.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class JSFUtil {
    
    public static void mesajekle(String ozet,String detay){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    ozet, detay));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
    
       public static void hataMesajiekle(String ozet,String detay){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    ozet, detay));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
     public static HttpSession getSession() {
        return (HttpSession)
          FacesContext.getCurrentInstance().
                  getExternalContext().getSession(false);
      }
     
     
     public static void sessionBitir(){
         FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
         
         
     }      
      public static HttpServletRequest getRequest() {
       return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
      }

      public static String getUserName()
      {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return  session.getAttribute("username").toString();
      }
      
      public static String getUserId()
      {
        HttpSession session = getSession();
        if ( session != null )
            return (String) session.getAttribute("userid");
        else
            return null;
      }
}
