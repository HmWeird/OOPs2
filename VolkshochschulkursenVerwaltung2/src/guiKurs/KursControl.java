package guiKurs;

import business.KursModel;
import business.Volkshochschulkurs;
import javafx.stage.Stage;

public class KursControl {
    private KursView kursView;
    private KursModel kursModel;

    public KursControl(Stage primaryStage) {
        this.kursModel = KursModel.getInstance();
        this.kursView = new KursView(this, primaryStage, kursModel);
    }

   

    public void leseKurseAusDatei(String typ) {
        try {
        	if(typ.equals("csv")) {
        		
            kursModel.leseAusCsvDatei();
        	}
        	else {
            kursModel.leseAusTxtDatei();
        	}
            kursView.zeigeInformationsfensterAn("Die Kurse wurden erfolgreich geladen!");
        } catch (Exception exc) {
            kursView.zeigeFehlermeldungsfensterAn("Fehler beim Laden der Datei: " + exc.getMessage());
        }
    }

    public void schreibeKurseInCsvDatei() {
        try {
            kursModel.schreibeKurseInCsvDatei();
            kursView.zeigeInformationsfensterAn("Die Kurse wurden erfolgreich gespeichert!");
        } catch (Exception exc) {
            kursView.zeigeFehlermeldungsfensterAn("Fehler beim Speichern der Datei: " + exc.getMessage());
        }
    }
}
