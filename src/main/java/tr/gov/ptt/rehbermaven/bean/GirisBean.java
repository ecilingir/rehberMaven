/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.rehbermaven.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import tr.gov.ptt.rehbermaven.entity.Giris;
import tr.gov.ptt.rehbermaven.service.GirisService;
import tr.gov.ptt.rehbermaven.util.JSFUtil;

@ManagedBean
@RequestScoped
public class GirisBean {

    private Giris giris = new Giris();
    @EJB
    GirisService girisService;

    public GirisBean() {
    }

    public Giris getGiris() {
        return giris;
    }

    public void setGiris(Giris giris) {
        this.giris = giris;
    }

    public String giriseYetkilimi() {
        boolean sonuc = girisService.GiriseYetkilimi(giris);
        if (sonuc) {
            HttpSession session = JSFUtil.getSession();
            System.out.println(session.getId() + " nolu session başlıyor.");
            session.setAttribute("kullanici", giris.getKullanici());
            return "menu.xhtml?faces-redirect=true";
        } else {
            JSFUtil.hataGoster("Hatalı Giriş", "Kullanıcı adı veya Şifre yalnış!!!");
            return "giris.xhtml?faces-redirect=true";
        }

    }

    public String guvenliCikis() {
        HttpSession session = JSFUtil.getSession();
        JSFUtil.SessionBitir(session);
        JSFUtil.mesajGoster("Session bitti", "Yeniden giriş yapınız");
        return "giris.xhtml?faces-redirect=true";
    }

}
