package tr.gov.ptt.rehbermaven.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.rehbermaven.entity.Kisi;
import tr.gov.ptt.rehbermaven.entity.Log;
import tr.gov.ptt.rehbermaven.facade.KisiFacade;
import tr.gov.ptt.rehbermaven.facade.LogFacade;
import tr.gov.ptt.rehbermaven.util.JSFUtil;

@Stateless
public class KisiService {

    @EJB
    private KisiFacade kisiFacade;
    @EJB
    LogFacade logFacade;

    public void ekle(Kisi p_kisi) {
        kisiFacade.create(p_kisi);
        Log log = new Log();
        log.setKullanici(JSFUtil.getKullanici());
        log.setTarihsaat(new java.util.Date());
        log.setIslem("Ekleme");
        log.setKisino(p_kisi.getNo());
        logFacade.create(log);

    }

    public List<Kisi> kisileriGetir() {
        return kisiFacade.findAll();

    }

}
