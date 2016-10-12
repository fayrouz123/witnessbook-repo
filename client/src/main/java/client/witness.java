package client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Service.WitnessCardServiceRemote;
import entities.WitnessCard;

public class witness {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		WitnessCardServiceRemote wsr = (WitnessCardServiceRemote) context
				.lookup("witnessbook-ear/witnessbook-ejb/WitnessCardService!Service.WitnessCardServiceRemote");
		WitnessCard wc = new WitnessCard();
		wc.setCardId(1);
		wc.setCardName("TopHappiness");
		wc.setCardAddress("lac1");
		wc.setCardDescription("good");
		wc.setCardFile("scr:\\...");
		wsr.Addwcs(wc);

	}

}
