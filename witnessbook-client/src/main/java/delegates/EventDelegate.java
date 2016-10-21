package delegates;

import java.util.List;



import tn.esprit.sigma.witnessbook.entities.Event;

import tn.esprit.sigma.witnessbook.interfaces.IEventServiceRemote;

public class EventDelegate {

	private static IEventServiceRemote remote;
	private static String jndiName = "witnessbook-ear/witnessbook-ejb/EventService!tn.esprit.sigma.witnessbook.interfaces.IEventServiceRemote";
	
	private static IEventServiceRemote getProxy() {
		return (IEventServiceRemote) locator.ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void create(Event e){
		getProxy().create(e);
	}
	public static void delete(Event e){
		getProxy().remove(e);
	}
	public static void update(Event e){
		getProxy().edit(e);
	}
	public static List<Event> findAll(){
		return getProxy().findAll();
	}
	public static Event find(int idEvent){
		return getProxy().find(idEvent);
	}
}
