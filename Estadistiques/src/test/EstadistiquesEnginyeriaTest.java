package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.EstadistiquesEnginyeria;

class EstadistiquesEnginyeriaTest {

	MockDB DB = new MockDB();
	EstadistiquesEnginyeria EE = new EstadistiquesEnginyeria(DB);
	
	@Test
	void testConnectAndCloseDB() {

		assertEquals(DB.connect(), true);
		assertEquals(DB.close(), true);
	}
	
	void testQueryDB() {
		String[][] response = DB.query("SELECT * FROM notas WHERE = FISICA");
		assertEquals(response, false);// BD no esta conectada
		
		DB.connect(); //conectamos la BD
		assertEquals(response, true);
			
	}


}
