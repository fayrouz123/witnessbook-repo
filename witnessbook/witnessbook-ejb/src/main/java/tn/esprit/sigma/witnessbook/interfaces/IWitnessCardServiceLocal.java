package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;


import tn.esprit.sigma.witnessbook.entities.WitnessCard;

public interface IWitnessCardServiceLocal {
	void create(WitnessCard entity);
	 WitnessCard edit(WitnessCard entity);
	 void remove(WitnessCard entity);
	 WitnessCard find(Object id);
	 List<WitnessCard> findAll();
	 List<WitnessCard> findRange(int startPosition, int size);
	 int count();

}
