package writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import business.Volkshochschulkurs;

public class ConcreteWriterTxtProduct extends WriterProduct {
	BufferedWriter writer;

	public ConcreteWriterTxtProduct() throws IOException {
		writer = new BufferedWriter(new FileWriter("KurseAusgabe.txt",true));

	}

	public void fuegeInDateiHinzu(Volkshochschulkurs kurs) throws IOException {
		try {
			if (kurs == null)
				throw new NullPointerException("Keine Kurse zum schreiben!");
			writer.write("\n\nDaten des Kurses: \n");
			writer.write("\nname des Kurses:     " + kurs.getKursname());
			writer.write("\nKurs Betrag:    " + kurs.getKursbeitrag());
			writer.write("\nKurs Wochentag:    " + kurs.getWochentag());
			writer.write("\nKurs Startuhrzeit:    " + kurs.getStartuhrzeit());
			writer.write("\nKurs Vorkenntnisse:    " + kurs.getVorkenntnisseAlsString(','));
			


		//writer.write(kurs.gibKursDetailsZurueck(';'));
			
		} catch (IOException exc) {
			throw new IOException("Fehler beim Speichern der Datei!");
		}
	}
	
	@Override
	public void schliesseDatei() throws IOException {
		writer.close();
	}

}
