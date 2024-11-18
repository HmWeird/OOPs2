package business;
import readers.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class KursModel {
    private Volkshochschulkurs kurs;

    public void addKurs(Volkshochschulkurs newKurs) {
        this.kurs = newKurs;
    }
    public Volkshochschulkurs getKurs() {
        return this.kurs;
    }

    public void leseAusCsvDatei() throws Exception {
    	
    	ReaderCreator wc = new ConcreteCsvCreator();
    	ReaderProduct wp = wc.factoryMethod();
    	String zeile [] = wp.leseAusDatei ();
    	kurs = new Volkshochschulkurs ( zeile[0] ,Float.parseFloat(zeile[1]), zeile[2], zeile[3] , zeile[4].split("_") );
    			wp.schliesseDatei();
    	
    	
       
    }
    
    public void leseAusTxtDatei () throws Exception {
    	ReaderCreator wc = new ConcreteTxtCreator();
    	ReaderProduct wp = wc.factoryMethod();
    	String zeile [] = wp.leseAusDatei();
    	kurs = new Volkshochschulkurs ( zeile[0] ,Float.parseFloat(zeile[1]), zeile[2], zeile[3] , zeile[4].split("_") );
		wp.schliesseDatei();
    	
    	
    	
    }

    public void schreibeKurseInCsvDatei() throws Exception {
        if (this.kurs == null) throw new NullPointerException("Kein Kurs zum Speichern.");
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("KurseAusgabe.csv", true))) {
            writer.write(kurs.gibKursDetailsZurueck(';'));
        } catch (IOException exc) {
            throw new IOException("Fehler beim Speichern der Datei!");
        }
    }

        
}
