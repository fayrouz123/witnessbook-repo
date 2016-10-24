package delegates;

import java.util.List;


import tn.esprit.sigma.witnessbook.entities.BadWord;
import tn.esprit.sigma.witnessbook.interfaces.IBadWordServiceRemote;

public class BadWordDelegate {
	

	private static String jndiName = "witnessbook-ear/witnessbook-ejb/BadWordService!tn.esprit.sigma.witnessbook.interfaces.IBadWordServiceRemote";
	
	private static IBadWordServiceRemote getProxy() {
		return (IBadWordServiceRemote) locator.ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void create(BadWord bw){
		getProxy().create(bw);;
	}
	public static void delete(BadWord bw){
		getProxy().remove(bw);;
	}
	public static void update(BadWord bw){
		getProxy().edit(bw);
	}
	public static List<BadWord> findAll(){
		return getProxy().findAll();
	}
	public static BadWord find(int id){
		return getProxy().find(id);
	}
	}




