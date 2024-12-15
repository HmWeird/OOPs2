package kurse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Volkshochschulkurs;

class KurseTest {
		private Volkshochschulkurs kurs;

	@BeforeEach
	void setUp() throws Exception {
		String array [] =  new String [1];
		array[0] = "kurs";
		this.kurs = new Volkshochschulkurs ("DataBase", 3, "DI", null, array);
	}  

	@AfterEach
	void tearDown() throws Exception {
		this.kurs = null;
	}

	@Test
	void test() {
		assertTrue(this.kurs.getKursbeitrag()==3, "Ihre eingabe ist 30 ");
		
	}
	@Test
	 void test2() {
		String array [] =  new String [1];
		array[0] = "kurs";
	        Throwable exc= assertThrows(IllegalArgumentException.class,() -> {new Volkshochschulkurs("DB",9,"MI", "n",null);});
	        assertEquals("Vorkenntnisse duerfen nicht null sein.", exc.getMessage());
	   
	    }
	
	
}
