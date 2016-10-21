package witnesscard;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import tn.esprit.sigma.witnessbook.entities.Category;
import tn.esprit.sigma.witnessbook.entities.WitnessCard;
import tn.esprit.sigma.witnessbook.service.WitnessCardServiceRemote;


public class WitnessCardController {

	
	@FXML
	private javafx.scene.control.Button AddWC;
	
	
	@FXML
	private javafx.scene.control.TextField witnessCardName;
	
	@FXML
	private javafx.scene.control.TextArea witnessCardDescription;
	
	
	@FXML
	private javafx.scene.control.TextField  witnessCardAddress;
	
	
	@FXML
	private ComboBox<Category> witnessCardCategory;
	
	@FXML
	private javafx.scene.control.Button UpploadImage;
	
	
	@FXML
	private javafx.scene.control.TextField witnessCardSearchName;
	
	
	@FXML
	private javafx.scene.control.Button	ShowAllWitnessCards;
	
	
	@FXML
    void AddWitnessCard(ActionEvent event) throws NamingException{
		
		Context context = new InitialContext();
		WitnessCardServiceRemote wcsr = (WitnessCardServiceRemote) context.lookup("witnessbook-ear/witnessbook-ejb/WitnessCardService!tn.esprit.sigma.witnessbook.service.WitnessCardServiceRemote");
		WitnessCard wc = new WitnessCard();
		wc.setName(witnessCardName.getText());
		wc.setDescription(witnessCardDescription.getText());
		wc.setAddress(witnessCardAddress.getText());
		//wc.setCategory(witnessCardCategory.getValue());
	    //wc.setAttachement(UpploadImage.getLabel());
		wcsr.create(wc); 

		
	}

	
	
	
	
}
