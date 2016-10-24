package delegates;





import java.util.List;

import tn.esprit.sigma.witnessbook.entities.Witness;
import tn.esprit.sigma.witnessbook.interfaces.IWitnessServiceRemote;



public class WitnessDelagate {

	private static String jndiName = "witnessbook-ear/witnessbook-ejb/WitnessService!tn.esprit.sigma.witnessbook.interfaces.IWitnessServiceRemote";
	
	private static IWitnessServiceRemote getProxy() {
		return (IWitnessServiceRemote) locator.ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void create(Witness r){
		getProxy().create(r);
	}
	public static void delete(Witness r ){
		getProxy().remove(r);
	}
	public static void update(Witness r){
		getProxy().edit(r);
	}
	public static List<Witness> findAll(){
		return getProxy().findAll();
	}
	public static Witness find(int id){
		return getProxy().find(id);
	}
	}


