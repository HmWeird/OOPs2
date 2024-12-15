package writers;

import java.io.IOException;

public class ConcreteWriterCreator extends WriterCreator{

	@Override
	public WriterProduct factoryMethod() throws IOException {
		// TODO Auto-generated method stub
		return new ConcreteWriterCsvProduct();
	}

}
