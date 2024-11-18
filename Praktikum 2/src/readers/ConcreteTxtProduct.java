package readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteTxtProduct extends ReaderProduct {
		
	BufferedReader ein ;
	
	public ConcreteTxtProduct () throws IOException {
		ein = new BufferedReader ( new FileReader ("Kurse.txt"));
		
	}
	@Override
	public String[] leseAusDatei() throws IOException {
		String [] kursdetails = new String [5];
		String zeile = ein.readLine();
		int i = 0;
		while (i < kursdetails.length) {
			kursdetails[i] = zeile;
			zeile = ein.readLine();
			i++;
			
		}
		
		return kursdetails;
	}

	@Override
	public void schliesseDatei() throws IOException {

		ein.close();
	}

}
