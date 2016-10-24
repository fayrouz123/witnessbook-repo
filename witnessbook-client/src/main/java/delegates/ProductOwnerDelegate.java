package delegates;
import java.util.List;

import tn.esprit.sigma.witnessbook.entities.ProductOwner;
import tn.esprit.sigma.witnessbook.interfaces.IProductOwnerServiceRemote;



public class ProductOwnerDelegate {

	private static String jndiName = "witnessbook-ear/witnessbook-ejb/ProductOwnerService!tn.esprit.sigma.witnessbook.interfaces.IProductOwnerServiceRemote";
	
	private static IProductOwnerServiceRemote getProxy() {
		return (IProductOwnerServiceRemote) locator.ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void create(ProductOwner p){
		getProxy().create(p);
	}
	public static void delete(ProductOwner p ){
		getProxy().remove(p);
	}
	public static void update(ProductOwner p){
		getProxy().edit(p);
	}
	public static List<ProductOwner> findAll(){
		return getProxy().findAll();
	}
	public static ProductOwner find(int id){
		return getProxy().find(id);
	}
	}


