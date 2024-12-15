package writers;

import java.io.IOException;

import business.Volkshochschulkurs;

public abstract class WriterProduct {

	public abstract void fuegeInDateiHinzu (Volkshochschulkurs kurse) throws IOException ;
	
	public abstract void schliesseDatei() throws IOException ;
	
}
