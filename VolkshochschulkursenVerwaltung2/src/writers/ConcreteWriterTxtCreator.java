package writers;

import java.io.IOException;

public class ConcreteWriterTxtCreator extends WriterCreator {

	@Override
	public WriterProduct factoryMethod() throws IOException {
		return new ConcreteWriterTxtProduct();
	}

}
