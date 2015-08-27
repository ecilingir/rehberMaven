package tr.gov.ptt.rehbermaven.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.RowEditEvent;
import tr.gov.ptt.rehbermaven.entity.Kisi;
import tr.gov.ptt.rehbermaven.service.KisiService;
import tr.gov.ptt.rehbermaven.util.JSFUtil;

@ManagedBean
@SessionScoped
public class KisiBean {

    private Kisi kisi = new Kisi();
    private List<Kisi> kisiListesi = new ArrayList<>();
    @EJB
    private KisiService kisiService;

    public KisiBean() {
    }

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    @PostConstruct
    public void doldurKisiListe() {
        kisiListesi = kisiService.kisileriGetir();
    }

    public String ekle() {
        kisiService.ekle(kisi);
        JSFUtil.mesajGoster("Kişi Eklendi", kisi.getAd() + " " + kisi.getSoyad() + " eklendi.");
        kisiListeGuncelle();
        return "kisiListele.xhtml?faces-redirect=true";
    }

    public void kisiListeGuncelle() {
        kisiListesi = kisiService.kisileriGetir();
    }

    public List<Kisi> getKisiListe() {
        return kisiListesi;
    }

    public void onRowEdit(RowEditEvent p_event) {
        kisi = (Kisi) p_event.getObject();
        kisiService.guncelle(kisi);
        JSFUtil.mesajGoster("Kişi Güncellendi. ", kisi.getAd() + " " + kisi.getSoyad());
    }

    public void onRowCancel(RowEditEvent p_event) {
        kisi = (Kisi) p_event.getObject();
        JSFUtil.mesajGoster("İşlem iptal edildi. ", kisi.getAd() + " " + kisi.getSoyad()+" güncellenemedi");
    }

    {
    }
}
