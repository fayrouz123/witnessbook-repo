package delegates;
import java.util.List;

import tn.esprit.sigma.witnessbook.entities.Post;
import tn.esprit.sigma.witnessbook.interfaces.IPostServiceRemote;



public class PostDelegate {

	private static String jndiName = "witnessbook-ear/witnessbook-ejb/PostService!tn.esprit.sigma.witnessbook.interfaces.IPostServiceRemote";
	
	private static IPostServiceRemote getProxy() {
		return (IPostServiceRemote) locator.ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void create(Post p){
		getProxy().create(p);
	}
	public static void delete(Post p ){
		getProxy().remove(p);
	}
	public static void update(Post p){
		getProxy().edit(p);
	}
	public static List<Post> findAll(){
		return getProxy().findAll();
	}
	public static Post find(int id){
		return getProxy().find(id);
	}
	}


