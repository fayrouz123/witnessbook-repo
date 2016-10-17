package tn.esprit.sigma.witnessbook.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.esprit.sigma.witnessbook.entities.Notification;
import tn.esprit.sigma.witnessbook.service.AbstractService;

@Stateless
@Named("notification")
public class NotificationService extends AbstractService<Notification> {

    @PersistenceContext(unitName = "DEFAULT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotificationService() {
        super(Notification.class);
    }

}
