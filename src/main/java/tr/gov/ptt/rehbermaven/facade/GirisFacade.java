package tr.gov.ptt.rehbermaven.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.rehbermaven.entity.Giris;

@Stateless
public class GirisFacade extends AbstractFacade<Giris> {

    @PersistenceContext(unitName = "RehberMavenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GirisFacade() {
        super(Giris.class);
    }

    public Boolean GirisKontrol(Giris p_giris) {
        try 
        {
            Giris giris = em.createNamedQuery("Giris.girisKontrol", Giris.class).setParameter("kullanici", p_giris.getKullanici())
                    .setParameter("sifre", p_giris.getSifre()).getSingleResult();
            return true;

        } catch (NoResultException nre) 
        {
            return false;
        }
    }

}
