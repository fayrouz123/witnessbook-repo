package delegates;
import java.util.List;

import tn.esprit.sigma.witnessbook.entities.Report;
import tn.esprit.sigma.witnessbook.interfaces.IReportServiceRemote;



public class ReportDelegate {

	private static String jndiName = "witnessbook-ear/witnessbook-ejb/ReportService!tn.esprit.sigma.witnessbook.interfaces.IReportServiceRemote";
	
	private static IReportServiceRemote getProxy() {
		return (IReportServiceRemote) locator.ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void create(Report r){
		getProxy().create(r);
	}
	public static void delete(Report r ){
		getProxy().remove(r);
	}
	public static void update(Report r){
		getProxy().edit(r);
	}
	public static List<Report> findAll(){
		return getProxy().findAll();
	}
	public static Report find(int id){
		return getProxy().find(id);
	}
	}


