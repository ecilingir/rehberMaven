/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.rehbermaven.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tr.gov.ptt.rehbermaven.entity.Giris;
import tr.gov.ptt.rehbermaven.service.GirisService;

@ManagedBean
@RequestScoped
public class GirisBean {
    private Giris giris=new Giris();
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
    public String giriseYetkilimi()
    {
        boolean sonuc=girisService.GiriseYetkilimi(giris);
        if(sonuc)
            return "menu.xhtml";
        else
            return "giris.xhtml";
    }
    
}
