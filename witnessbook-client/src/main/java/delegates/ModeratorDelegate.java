package delegates;

import java.util.List;

import tn.esprit.sigma.witnessbook.entities.Moderator;
import tn.esprit.sigma.witnessbook.interfaces.IModeratorServiceRemote;

public class ModeratorDelegate {

	
	private static String jndiName = "witnessbook-ear/witnessbook-ejb/ModeratorService!tn.esprit.sigma.witnessbook.interfaces.IModeratorServiceRemote";
	
	private static IModeratorServiceRemote getProxy() {
		return (IModeratorServiceRemote) locator.ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void create(Moderator m  ){
		getProxy().create(m);
	}
	public static void delete(Moderator m ){
		getProxy().remove(m);
	}
	public static void update(Moderator m ){
		getProxy().edit(m);
	}
	public static List<Moderator> findAll(){
		return getProxy().findAll();
	}
	public static Moderator find(int id){
		return getProxy().find(id);
	}
}
