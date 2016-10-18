package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.sigma.witnessbook.entities.Notification;


@Local
public interface INotificationServiceLocal {
	void create(Notification entity);
	Notification edit(Notification entity);
	 void remove(Notification entity);
	 Notification find(Object id);
	 List<Notification> findAll();
	 List<Notification> findRange(int startPosition, int size);
	 int count();
}
