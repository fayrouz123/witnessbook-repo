package delegates;
import java.util.List;

import tn.esprit.sigma.witnessbook.entities.Users;
import tn.esprit.sigma.witnessbook.interfaces.IUserServiceRemote;



public class UsersDelegate {

	private static IUserServiceRemote remote;
	private static String jndiName = "witnessbook-ear/witnessbook-ejb/UsersService!tn.esprit.sigma.witnessbook.interfaces.IUserServiceRemote";
	
	private static IUserServiceRemote getProxy() {
		return (IUserServiceRemote) locator.ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void create(Users r){
		getProxy().create(r);
	}
	public static void delete(Users r ){
		getProxy().remove(r);
	}
	public static void update(Users r){
		getProxy().edit(r);
	}
	public static List<Users> findAll(){
		return getProxy().findAll();
	}
	public static Users find(int id){
		return getProxy().find(id);
	}
	}


