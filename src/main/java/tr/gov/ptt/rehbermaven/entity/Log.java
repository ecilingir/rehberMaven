/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.rehbermaven.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BEM
 */
@Entity
@Table(name = "LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findBySirano", query = "SELECT l FROM Log l WHERE l.sirano = :sirano"),
    @NamedQuery(name = "Log.findByKullanici", query = "SELECT l FROM Log l WHERE l.kullanici = :kullanici"),
    @NamedQuery(name = "Log.findByTarihsaat", query = "SELECT l FROM Log l WHERE l.tarihsaat = :tarihsaat"),
    @NamedQuery(name = "Log.findByIslem", query = "SELECT l FROM Log l WHERE l.islem = :islem"),
    @NamedQuery(name = "Log.findByKisino", query = "SELECT l FROM Log l WHERE l.kisino = :kisino")})
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIRANO")
    private BigDecimal sirano;
    @Size(max = 30)
    @Column(name = "KULLANICI")
    private String kullanici;
    @Column(name = "TARIHSAAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tarihsaat;
    @Size(max = 50)
    @Column(name = "ISLEM")
    private String islem;
    @Column(name = "KISINO")
    private BigInteger kisino;

    public Log() {
    }

    public Log(BigDecimal sirano) {
        this.sirano = sirano;
    }

    public BigDecimal getSirano() {
        return sirano;
    }

    public void setSirano(BigDecimal sirano) {
        this.sirano = sirano;
    }

    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    public Date getTarihsaat() {
        return tarihsaat;
    }

    public void setTarihsaat(Date tarihsaat) {
        this.tarihsaat = tarihsaat;
    }

    public String getIslem() {
        return islem;
    }

    public void setIslem(String islem) {
        this.islem = islem;
    }

    public BigInteger getKisino() {
        return kisino;
    }

    public void setKisino(BigInteger kisino) {
        this.kisino = kisino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sirano != null ? sirano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.sirano == null && other.sirano != null) || (this.sirano != null && !this.sirano.equals(other.sirano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.ptt.rehbermaven.entity.Log[ sirano=" + sirano + " ]";
    }
    
}
