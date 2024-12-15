package guiKurs;

import business.KursModel;
import business.Volkshochschulkurs;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.Observer;

public class KursView implements Observer{
	private Pane pane = new Pane();
	private Label lblEingabe = new Label("Eingabe");
	private Label lblAnzeige = new Label("Anzeige");
	private Label lblKursname = new Label("Kursname:");
	private Label lblKursbeitrag = new Label("Kursbeitrag:");
	private Label lblWochentag = new Label("Wochentag:");
	private Label lblStartuhrzeit = new Label("Startuhrzeit:");
	private Label lblVorkenntnisse = new Label("Vorkenntnisse:");

	private TextField txtKursname = new TextField();
	private TextField txtKursbeitrag = new TextField();
	private TextField txtWochentag = new TextField();
	private TextField txtStartuhrzeit = new TextField();
	private TextField txtVorkenntnisse = new TextField();
	private TextArea txtAnzeige = new TextArea();

	private Button btnEingabe = new Button("Eingabe");
	private Button btnAnzeige = new Button("Anzeige");
	private MenuBar mnbrMenuLeiste = new MenuBar();
	private Menu mnDatei = new Menu("Datei");
	private MenuItem mnItmCsvImport = new MenuItem("csv-Import");
	private MenuItem mnItmTxtImport = new MenuItem("txt-Import");
	private MenuItem mnItmCsvExport = new MenuItem("csv-Export");

	private KursControl kursControl;
	private KursModel kursModel;

	public KursView(KursControl kursControl, Stage primaryStage, KursModel kursModel) {
		this.kursControl = kursControl;
		this.kursModel = kursModel;
		this.kursModel.addObserver(this);
		Scene scene = new Scene(this.pane, 700, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Verwaltung von Volkshochschulkursen");
		primaryStage.show();
		this.initKomponenten();
		this.initListener();
	}

	private void initKomponenten() {
		lblEingabe.setLayoutX(20);
		lblEingabe.setLayoutY(40);
		lblEingabe.setFont(new Font("Arial", 24));
		lblEingabe.setStyle("-fx-font-weight: bold;");

		lblAnzeige.setLayoutX(400);
		lblAnzeige.setLayoutY(40);
		lblAnzeige.setFont(new Font("Arial", 24));
		lblAnzeige.setStyle("-fx-font-weight: bold;");

		lblKursname.setLayoutX(20);
		lblKursname.setLayoutY(90);
		lblKursbeitrag.setLayoutX(20);
		lblKursbeitrag.setLayoutY(130);
		lblWochentag.setLayoutX(20);
		lblWochentag.setLayoutY(170);
		lblStartuhrzeit.setLayoutX(20);
		lblStartuhrzeit.setLayoutY(210);
		lblVorkenntnisse.setLayoutX(20);
		lblVorkenntnisse.setLayoutY(250);

		txtKursname.setLayoutX(170);
		txtKursname.setLayoutY(90);
		txtKursbeitrag.setLayoutX(170);
		txtKursbeitrag.setLayoutY(130);
		txtWochentag.setLayoutX(170);
		txtWochentag.setLayoutY(170);
		txtStartuhrzeit.setLayoutX(170);
		txtStartuhrzeit.setLayoutY(210);
		txtVorkenntnisse.setLayoutX(170);
		txtVorkenntnisse.setLayoutY(250);

		txtAnzeige.setEditable(false);
		txtAnzeige.setLayoutX(400);
		txtAnzeige.setLayoutY(90);
		txtAnzeige.setPrefWidth(270);
		txtAnzeige.setPrefHeight(185);

		btnEingabe.setLayoutX(20);
		btnEingabe.setLayoutY(290);
		btnAnzeige.setLayoutX(400);
		btnAnzeige.setLayoutY(290);

		pane.getChildren().addAll(lblEingabe, lblAnzeige, lblKursname, lblKursbeitrag, lblWochentag, lblStartuhrzeit,
				lblVorkenntnisse, txtKursname, txtKursbeitrag, txtWochentag, txtStartuhrzeit, txtVorkenntnisse,
				txtAnzeige, btnEingabe, btnAnzeige, mnbrMenuLeiste);
		mnbrMenuLeiste.getMenus().add(mnDatei);
		mnDatei.getItems().addAll(mnItmCsvImport, mnItmTxtImport, new SeparatorMenuItem(), mnItmCsvExport);
	}

	 public void nehmeKursAuf() {
	        try {
	            Volkshochschulkurs kurs = new Volkshochschulkurs(
	                txtKursname.getText(),
	                Float.parseFloat(txtKursbeitrag.getText()),
	                txtWochentag.getText(),
	            	txtStartuhrzeit.getText(),
	            	txtVorkenntnisse.getText().split(";")
	            );
	            kursModel.addKurs(kurs);
	        zeigeInformationsfensterAn("Der Kurs wurde erfolgreich aufgenommen!");
	        } catch (Exception exc) {
	         zeigeFehlermeldungsfensterAn("Fehler bei der Eingabe: " + exc.getMessage());
	        }
	    }

	    public void zeigeKurseAn() {
	    StringBuffer text = new StringBuffer(); 

	        if (kursModel.getKurs() != null) {
	        	for (Volkshochschulkurs kurs : this.kursModel.getKurs()) {
	        		text.append((kurs.gibKursDetailsZurueck(' ')) + "\n");
	        	
	        }
	        	this.txtAnzeige.setText(text.toString());	
	        } else {
	            zeigeFehlermeldungsfensterAn("Bisher wurde kein Kurs aufgenommen!");
	        }
	    }
	    
	    
	private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent e) {
	       nehmeKursAuf();
	        }
	    });
	    
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent e) {
	          zeigeKurseAn();
	        } 
	    });
	    
	    mnItmCsvImport.setOnAction(e->kursControl.leseKurseAusDatei("csv"));
	    
	    mnItmTxtImport.setOnAction(e->kursControl.leseKurseAusDatei("txt"));
	    
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent e) {
	            kursControl.schreibeKurseInCsvDatei(); 
	        }	
	    });
	}
	
	

	public void zeigeInformationsfensterAn(String meldung) {
		new Alert(AlertType.INFORMATION, meldung).showAndWait();
	}

	public void zeigeFehlermeldungsfensterAn(String meldung) {
		new Alert(AlertType.ERROR, meldung).showAndWait();
	}

	@Override
	public void update() {
		this.zeigeKurseAn();
	}

}
