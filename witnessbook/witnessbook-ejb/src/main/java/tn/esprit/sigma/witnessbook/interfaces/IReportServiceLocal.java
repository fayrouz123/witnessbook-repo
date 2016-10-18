package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.sigma.witnessbook.entities.Report;
@Local
public interface IReportServiceLocal {
	
	void create(Report entity);
	Report edit(Report entity);
	 void remove(Report entity);
	 Report find(Object id);
	 List<Report> findAll();
	 List<Report> findRange(int startPosition, int size);
	 int count();

}
