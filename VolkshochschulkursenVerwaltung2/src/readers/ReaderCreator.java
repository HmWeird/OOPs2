package readers;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class ReaderCreator {

		public abstract ReaderProduct factoryMethod () throws FileNotFoundException, IOException;
}
