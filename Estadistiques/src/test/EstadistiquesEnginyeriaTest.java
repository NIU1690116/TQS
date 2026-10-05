package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import domain.EstadistiquesEnginyeria;

class EstadistiquesEnginyeriaTest {
	
	private MockDB mockDB;
    private EstadistiquesEnginyeria estadistiques;
	
	@Before
	public void setUp() {
		mockDB = new MockDB();
		estadistiques = new EstadistiquesEnginyeria(mockDB);
		
	}

	@Test
	void testConnectAndCloseDB() {

		assertEquals(mockDB.connect(), true);//connected = true
		assertEquals(mockDB.close(), false);//connected = false
	}
	
	@Test
	void testQueryDB() {
		try {
			String[][] response = mockDB.query("SELECT * FROM notas WHERE assignatura = FISICA");
		} catch (IllegalStateException e) {
			assertEquals(e.getMessage(), "La base de dades no està connectada");// BD no esta conectada
		}
		
		mockDB.connect();
		String[][] response = mockDB.query("SELECT * FROM notas WHERE assignatura = FISICA");
		assertNotNull(response);
		assertEquals(4, response.length); // Hauria de retornar 4 files d'alumnes
		mockDB.close();
	}
	
	@Test
	void testPerCentAprovats() {
		
		Double response = estadistiques.PerCentAprovats("Fisica", "NFinal");
		assertEquals(response, 50.0, 0.001);//2 aprovats (7.7, 5.5) -> 50%
	}
	
	@Test
	void testPerCentSuspesos() {
		Double response = estadistiques.PerCentSuspesos("Fisica", "NFinal");
		assertEquals(response, 25.0, 0.001);// 1 suspès (3.5) -> 25%
	}
	
	@Test
	void testPerCentNoPresentats() {
		Double response = estadistiques.PerCentNoPresentats("Fisica", "NFinal");
		assertEquals(response, 25.0, 0.001);//1 no presentat (NP) -> 25%
	}

}
