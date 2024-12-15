package writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import business.Volkshochschulkurs;

public class ConcreteWriterCsvProduct extends WriterProduct {

	BufferedWriter writer;

	public ConcreteWriterCsvProduct() throws IOException {

		writer = new BufferedWriter(new FileWriter("KurseAusgabe.csv", true));
	}

	@Override
	public void fuegeInDateiHinzu(Volkshochschulkurs kurs) throws IOException {
		try {
			if (kurs == null)
				throw new NullPointerException("Kein Kurs zum Speichern.");

			writer.write(kurs.gibKursDetailsZurueck(';'));
		} catch (IOException exc) {
			throw new IOException("Fehler beim Speichern der Datei!");
		}

	}

	@Override
	public void schliesseDatei() throws IOException {
		writer.close();
	}

}
