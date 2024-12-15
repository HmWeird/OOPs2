package guiWissenschaftUndBildung;

import business.KursModel;
import business.Volkshochschulkurs;
import guiKurs.KursControl;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class WissenschaftUndBildungView implements Observer{

	private WissenschaftUndBildungControl wissenschaftUndBildungControl;
	private KursModel volkshochschulkurseModel;
	private WissenschaftUndBildungView wissenschaft;
	
	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblAnzeigeVolkshochschulkurse = new Label("Anzeige Volkshochschulkurse");
	private TextArea txtAnzeigeVolkshochschulkurse = new TextArea();
	private Button btnAnzeigeVolkshochschulkurse = new Button("Anzeige");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public WissenschaftUndBildungView(WissenschaftUndBildungControl wissenschaftUndBildungControl, Stage primaryStage, KursModel volkshochschulkurseModel) {
		this.volkshochschulkurseModel = KursModel.getInstance();
		this.volkshochschulkurseModel.addObserver(this);
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Bildungsangeboten");
		primaryStage.show();
		this.wissenschaftUndBildungControl = wissenschaftUndBildungControl;
		this.volkshochschulkurseModel = volkshochschulkurseModel;
		this.initKomponenten();
		this.initListener();
	}

	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeVolkshochschulkurse.setLayoutX(310);
    		lblAnzeigeVolkshochschulkurse.setLayoutY(40);
    		lblAnzeigeVolkshochschulkurse.setFont(font);
    		lblAnzeigeVolkshochschulkurse.setStyle("fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeVolkshochschulkurse);           
        	txtAnzeigeVolkshochschulkurse.setEditable(false);
     		txtAnzeigeVolkshochschulkurse.setLayoutX(310);
    		txtAnzeigeVolkshochschulkurse.setLayoutY(90);
     		txtAnzeigeVolkshochschulkurse.setPrefWidth(220);
    		txtAnzeigeVolkshochschulkurse.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeVolkshochschulkurse);    	
        	// Button
          	btnAnzeigeVolkshochschulkurse.setLayoutX(310);
        	btnAnzeigeVolkshochschulkurse.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeVolkshochschulkurse); 
   }

	private void initListener() {
		btnAnzeigeVolkshochschulkurse.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeVolkshochschulkurseAn();
			}
		});
	}

	private void zeigeVolkshochschulkurseAn() {
	 StringBuffer text = new StringBuffer(); 
		if (volkshochschulkurseModel.getKurs() != null) {
			for (Volkshochschulkurs kurs : volkshochschulkurseModel.getKurs()) {
				text.append((kurs.gibKursDetailsZurueck(' ')) + "\n");
			}
        	this.txtAnzeigeVolkshochschulkurse.setText(text.toString());	

		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Volkshochschulkurs aufgenommen!");
		
		update();
		}
	}

	private void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	@Override
	public void update() {
		this.zeigeVolkshochschulkurseAn();
	}

}
