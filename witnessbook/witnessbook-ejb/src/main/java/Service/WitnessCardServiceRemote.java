package Service;

import javax.ejb.Remote;

import entities.WitnessCard;

@Remote
public interface WitnessCardServiceRemote {
	void Addwcs(WitnessCard wc);
}
