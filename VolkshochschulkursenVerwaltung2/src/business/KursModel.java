package business;
import readers.*;
import ownUtil.Observable;
import ownUtil.Observer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class KursModel implements Observable {
    private ArrayList < Volkshochschulkurs > kurs = new ArrayList <> ();
    private static KursModel kursmodel;
    private Vector <Observer> observers = new Vector <Observer>();
    private KursModel() {
    	
    }
    
    public static KursModel getInstance() {
    	if(kursmodel==null) {
    		kursmodel = new KursModel();
    	}
    	return kursmodel;
    }
    
    public void setKurs (Volkshochschulkurs kurs) {
    	this.kurs.add(kurs);
    	notifyObserver();
    	
    }
    
    public void addKurs(Volkshochschulkurs newKurs) {
        this.kurs.add(newKurs);
        notifyObserver();
    }
    public ArrayList <Volkshochschulkurs> getKurs() {
        return this.kurs;
    }

    public void leseAusCsvDatei() throws Exception {
    	
    	ReaderCreator wc = new ConcreteCsvCreator();
    	ReaderProduct wp = wc.factoryMethod();
    	String zeile [] = wp.leseAusDatei ();
    	kurs.add(new Volkshochschulkurs ( zeile[0] ,Float.parseFloat(zeile[1]), zeile[2], zeile[3] , zeile[4].split("_") ));
    			wp.schliesseDatei();
    			notifyObserver();
    
    	
       
    }
    
    public void leseAusTxtDatei () throws Exception {
    	ReaderCreator wc = new ConcreteTxtCreator();
    	ReaderProduct wp = wc.factoryMethod();
    	String zeile [] = wp.leseAusDatei();
    	kurs.add(new Volkshochschulkurs ( zeile[0] ,Float.parseFloat(zeile[1]), zeile[2], zeile[3] , zeile[4].split("_") ));
		wp.schliesseDatei();
		notifyObserver();
    	
    	
    	
    }
    
    

    public void schreibeKurseInCsvDatei() throws Exception {
        if (this.kurs == null) throw new NullPointerException("Kein Kurs zum Speichern.");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("KurseAusgabe.csv", true))) {
        	for (Volkshochschulkurs volkshochschulkurs : kurs) {
				
            writer.write(volkshochschulkurs.gibKursDetailsZurueck(';'));
        	}
        } catch (IOException exc) {
            throw new IOException("Fehler beim Speichern der Datei!");
        }
    }

	@Override
	public void addObserver(Observer obs) {
		this.observers.addElement(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		this.observers.addElement(obs);
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

        
}
