package readers;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ConcreteTxtCreator extends ReaderCreator {

	@Override
	public ReaderProduct factoryMethod() throws IOException {
		
		return	new ConcreteTxtProduct();
	}
	
	
}
