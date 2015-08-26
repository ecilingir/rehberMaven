
package tr.gov.ptt.rehbermaven.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.rehbermaven.entity.Giris;
import tr.gov.ptt.rehbermaven.facade.GirisFacade;

@Stateless
public class GirisService {
    
    @EJB
    GirisFacade girisFacade;
    public Boolean GiriseYetkilimi(Giris p_giris)
    {
       return  girisFacade.GirisKontrol(p_giris);
    }
    
}
