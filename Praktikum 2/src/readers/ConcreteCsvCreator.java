package readers;

import java.io.FileNotFoundException;

public class ConcreteCsvCreator extends ReaderCreator{

	@Override
	public ReaderProduct factoryMethod() throws FileNotFoundException {
		// TODO Auto-generated method stub
		return new ConcreteCsvProduct();
	}
	
	
}
