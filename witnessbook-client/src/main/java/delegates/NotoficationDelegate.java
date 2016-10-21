package delegates;

import java.util.List;

import tn.esprit.sigma.witnessbook.entities.Notification;
import tn.esprit.sigma.witnessbook.interfaces.INotificationServiceRemote;

public class NotoficationDelegate {

	private static INotificationServiceRemote remote;
	private static String jndiName = "witnessbook-ear/witnessbook-ejb/NotificationService!tn.esprit.sigma.witnessbook.interfaces.INotificationServiceRemote";

	private static INotificationServiceRemote getProxy() {
		return (INotificationServiceRemote) locator.ServiceLocator.getInstance().getProxy(jndiName);
	}

	public static void create(Notification n) {
		getProxy().create(n);
	}

	public static void delete(Notification n) {
		getProxy().remove(n);
	}

	public static void update(Notification n) {
		getProxy().edit(n);
	}

	public static List<Notification> findAll() {
		return getProxy().findAll();
	}

	public static Notification find(int id) {
		return getProxy().find(id);
	}
}
