package delegates;

import java.util.List;

import tn.esprit.sigma.witnessbook.entities.Category;
import tn.esprit.sigma.witnessbook.interfaces.ICategoryServiceRemote;

public class CategoryDelegate {

	private static String jndiName = "witnessbook-ear/witnessbook-ejb/CategoryService!tn.esprit.sigma.witnessbook.interfaces.ICategoryServiceRemote";
	
	private static ICategoryServiceRemote getProxy() {
		return (ICategoryServiceRemote) locator.ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void create(Category c){
		getProxy().create(c);
	}
	public static void delete(Category c){
		getProxy().remove(c);
	}
	public static void update(Category c){
		getProxy().edit(c);
	}
	public static List<Category> findAll(){
		return getProxy().findAll();
	}
	
	
	
	public static Category find(int id){
		return getProxy().find(id);
	}
	}

