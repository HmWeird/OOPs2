package readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import business.Volkshochschulkurs;

public class ConcreteCsvProduct extends ReaderProduct {
	BufferedReader reader ;
	public ConcreteCsvProduct() throws FileNotFoundException {
		reader = new BufferedReader(new FileReader ("Kurse.csv"));
		
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
	//	String typ = null ;
		String [] data;
		Volkshochschulkurs kurs;
		// if ("csv".equals(typ)) {
	            try (BufferedReader reader = new BufferedReader(new FileReader("Kurse.csv"))) {
	                data = reader.readLine().split(";");
	              
	            } catch (IOException exc) {
	                throw new IOException("Fehler beim Lesen der Datei!");
	            }
	//         }
	 // else {
	          //  throw new UnsupportedOperationException("Dateityp nicht unterstützt!");
	   //      }
			return data;
	    }	
	

	@Override
	public void schliesseDatei() throws IOException {

		
	}

}
