package users;




import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tn.esprit.sigma.witnessbook.entities.Users;


public class authentificatController  {
	@FXML
	TextField login;
	@FXML
	PasswordField password;
	@FXML
	Button b1 ;
	@FXML
	AnchorPane Anchor ;
	@FXML 
	Hyperlink hyper;

	public static Stage s;

	public static Users connectedUser;

	@FXML
	public void hello(ActionEvent acEvent) {

	}


	
}
