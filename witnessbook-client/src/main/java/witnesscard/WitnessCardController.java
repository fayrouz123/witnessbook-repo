package witnesscard;

import java.awt.Button;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import tn.esprit.sigma.witnessbook.entities.Category;
import tn.esprit.sigma.witnessbook.entities.WitnessCard;

public class WitnessCardController {

	
	@FXML
	private Button AddWC;
	
	
	@FXML
	private TextField witnessCardName;
	
	@FXML
	private TextArea witnessCardDescription;
	
	
	@FXML
	private TextField witnessCardAddress;
	
	
	@FXML
	private ComboBox<Category> witnessCardCategory;
	
	@FXML
	private Button UpploadImage;
	
	
	@FXML
	private TextField witnessCardSearchName;
	
	
	@FXML
	private Button 	ShowAllWitnessCards;
	
	
	
	
	@FXML
	void AddWitnessCard(ActionEvent event){
		
		WitnessCard wc = new WitnessCard();
		wc.setName(witnessCardName.getText());
		wc.setDescription(witnessCardDescription.getText());
		wc.setAddress(witnessCardAddress.getText());
		wc.setCategory(witnessCardCategory.getValue());
	    //wc.setAttachement(UpploadImage.getLabel());
		
		
	
		
	}

	
	
	
	
}
