import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConversorTest {

	@BeforeEach 
	void setUp() throws Exception {
		
	}
	@Test
	void testCToF() {
		Conversor conv = new Conversor();
		double res_0 = conv.CToF(0);
		
		assertEquals(32, res_0, 1.e-6);
		
		double res_100 = conv.CToF(100);

		assertEquals(212, res_100, 1.e-6); 
	}
	
	@Test
	void testFToC() {
		Conversor conv = new Conversor();
		double res_0 = conv.FToC(0);
		
		assertEquals(32, res_0, 1.e-6);
		
		double res_100 = conv.FToC(100);

		assertEquals(212, res_100, 1.e-6); 
	}

}
