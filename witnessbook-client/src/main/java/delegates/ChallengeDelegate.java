package delegates;

import java.util.List;


import tn.esprit.sigma.witnessbook.entities.Challenge;

import tn.esprit.sigma.witnessbook.interfaces.IChallengeServiceRemote;

public class ChallengeDelegate {

	
	private static IChallengeServiceRemote remote;
	private static String jndiName = "witnessbook-ear/witnessbook-ejb/ChallengeService!tn.esprit.sigma.witnessbook.interfaces.IChallengeServiceRemote";
	
	private static IChallengeServiceRemote getProxy() {
		return (IChallengeServiceRemote) locator.ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void create(Challenge ch){
		getProxy().create(ch);
	}
	public static void delete(Challenge ch){
		getProxy().remove(ch);
	}
	public static void update(Challenge ch){
		getProxy().edit(ch);
	}
	public static List<Challenge> findAll(){
		return getProxy().findAll();
	}
	public static Challenge find(int id){
		return getProxy().find(id);
	}
}
