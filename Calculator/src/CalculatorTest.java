import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	
	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	SecondsCalculator secCalculator = new SecondsCalculator();
	
	
	@Test
	void testIsAnyTraspasValid() {
		
		boolean result_400  = secCalculator.getIsAnyTraspas(1600);
		assertEquals(true, result_400);
		
		boolean result_4  = secCalculator.getIsAnyTraspas(2004);
		assertEquals(true, result_4);
		
		boolean result  = secCalculator.getIsAnyTraspas(1980);
		assertEquals(true, result);
		
	}
	
	@Test
	void testIsAnyTraspasInvalid() {
		
		boolean result_100  = secCalculator.getIsAnyTraspas(2100);
		assertEquals(false, result_100);
		
		boolean result_4_100 = secCalculator.getIsAnyTraspas(1700);
		assertEquals(false, result_4_100);
		
		
		boolean resul_altres = secCalculator.getIsAnyTraspas(2001);
		assertEquals(false, resul_altres);	

	}
	
	
	@Test
	void testDiasDelMesValid() {
		
		int result_feb_28 = secCalculator.getDiesDelMes(2, 2004);
		assertEquals(29, result_feb_28);
		
		
		int result_feb_29 = secCalculator.getDiesDelMes(2, 2025);
		assertEquals(28, result_feb_29);
		
		int result_31 = secCalculator.getDiesDelMes(1, 2004);
		assertEquals(31, result_31);
		
		int result_30 = secCalculator.getDiesDelMes(4, 2004);
		assertEquals(30, result_30);
		
	}

	
	@Test
	void testSecondsDelMes() {
		
		int result = secCalculator.getSecondsDelMes(1, 2026);
		int secMes = 31 * 24 * 3600;
		assertEquals(secMes, result);
		
		int result_1 = secCalculator.getSecondsDelMes(2, 2004);
		int secMes_1 = 29 * 24 * 3600;
		assertEquals(secMes_1, result_1);
		
	}

	
	@Test
	void testIsFechaInvalid() {
		
		boolean result = secCalculator.isFechaValid(31, 12, 1979, 24, 60, 60);
		assertEquals(false, result);
		
	}
	
	@Test
	void testIsFechaValid() {
		
		boolean result = secCalculator.isFechaValid(1, 1, 1981, 1, 1, 1);
		assertEquals(true, result);
		
	}
	
	@Test
	void testSeconsFins() {
		
		long result = secCalculator.SeconsFins(1, 1, 1981, 0, 0, 0);
		int diesAny = 365;
		if (secCalculator.getIsAnyTraspas(1980)) {
			diesAny = 366;
		}
		long secondsFins = diesAny * 24 * 3600;
		assertEquals(secondsFins, result);
		
	}
	

}
