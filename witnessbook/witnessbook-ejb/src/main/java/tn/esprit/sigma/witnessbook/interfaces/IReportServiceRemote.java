package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.sigma.witnessbook.entities.Report;

@Remote
public interface IReportServiceRemote {

	void create(Report entity);

	Report edit(Report entity);

	void remove(Report entity);

	Report find(Object id);

	List<Report> findAll();

	List<Report> findRange(int startPosition, int size);

	int count();

}
