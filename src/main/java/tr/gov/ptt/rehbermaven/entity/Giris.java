/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.rehbermaven.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BEM
 */
@Entity
@Table(name = "GIRIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giris.findAll", query = "SELECT g FROM Giris g"),
    @NamedQuery(name = "Giris.girisKontrol", 
            query = "SELECT g FROM Giris g WHERE g.kullanici = :kullanici and g.sifre = :sifre"),
    @NamedQuery(name = "Giris.findByKullanici", query = "SELECT g FROM Giris g WHERE g.kullanici = :kullanici"),
    @NamedQuery(name = "Giris.findBySifre", query = "SELECT g FROM Giris g WHERE g.sifre = :sifre")})
public class Giris implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "KULLANICI")
    private String kullanici;
    @Size(max = 20)
    @Column(name = "SIFRE")
    private String sifre;

    public Giris() {
    }

    public Giris(String kullanici) {
        this.kullanici = kullanici;
    }

    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kullanici != null ? kullanici.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giris)) {
            return false;
        }
        Giris other = (Giris) object;
        if ((this.kullanici == null && other.kullanici != null) || (this.kullanici != null && !this.kullanici.equals(other.kullanici))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.ptt.rehbermaven.entity.Giris[ kullanici=" + kullanici + " ]";
    }
    
}
