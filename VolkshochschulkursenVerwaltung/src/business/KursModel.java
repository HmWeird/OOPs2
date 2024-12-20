package business;

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

    public void leseAusDatei(String typ) throws Exception {
        if ("csv".equals(typ)) {
            try (BufferedReader reader = new BufferedReader(new FileReader("Kurse.csv"))) {
                String[] data = reader.readLine().split(";");
                this.kurs = new Volkshochschulkurs(data[0],
                        Float.parseFloat(data[1]),
                        data[2],
                        data[3],
                        data[4].split("_"));
            } catch (IOException exc) {
                throw new IOException("Fehler beim Lesen der Datei!");
            }
        } else {
            throw new UnsupportedOperationException("Dateityp nicht unterstützt!");
        }
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
