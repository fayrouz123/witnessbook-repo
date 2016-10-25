package delegates;





import java.util.List;

import tn.esprit.sigma.witnessbook.entities.WitnessCard;
import tn.esprit.sigma.witnessbook.interfaces.IWitnessCardServiceRemote;



public class WitnessCardDelagate {

	private static IWitnessCardServiceRemote remote;
	private static String jndiName = "witnessbook-ear/witnessbook-ejb/WitnessCardService!tn.esprit.sigma.witnessbook.interfaces.IWitnessCardServiceRemote";
	
	private static IWitnessCardServiceRemote getProxy() {
		return (IWitnessCardServiceRemote) locator.ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void create(WitnessCard r){
		getProxy().create(r);
	}
	public static void delete(WitnessCard r ){
		getProxy().remove(r);
	}
	public static void update(WitnessCard r){
		getProxy().edit(r);
	}
	public static List<WitnessCard> findAll(){
		return getProxy().findAll();
	}
	public static WitnessCard find(int id){
		return getProxy().find(id);
	}
	
	public static List<WitnessCard> SearchWC(String wc){
		return getProxy().SearchWC(wc);
	}
	}


