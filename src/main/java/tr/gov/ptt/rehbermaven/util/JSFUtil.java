package tr.gov.ptt.rehbermaven.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {

    public static void mesajGoster(String p_mesaj, String p_detay) {
        FacesContext.getCurrentInstance().addMessage("null", new FacesMessage(FacesMessage.SEVERITY_INFO, p_mesaj, p_detay));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }

    public static void hataGoster(String p_mesaj, String p_detay) {
        FacesContext.getCurrentInstance().addMessage("null", new FacesMessage(FacesMessage.SEVERITY_ERROR, p_mesaj, p_detay));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }

}
