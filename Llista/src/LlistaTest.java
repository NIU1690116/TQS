import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class LlistaTest {
	
	@BeforeEach
	void setUp() throws Exception{
		
	}
	
	@Test
	void testLista() {
		Llista l = new Llista();
		assertEquals(l.getNElements(), 0);
		assertEquals(l.getPrimerElem(), null);
	}

	@Test
	void testAfegirUltim() {
		Llista l = new Llista();
		l.afegirUltim(2);
		assertEquals(l.getNElements(), 1);
		assertEquals(l.getPrimerElem().getValor(), 2);
		assertEquals(l.getPrimerElem().getNext(), null);
		
	}

	@Test
	void testInsertarValor() {
		Llista l = new Llista();
		l.afegirUltim(1); // l : 1
		l.afegirUltim(3); // l : 1, 3
		l.insertarValor(2, 2); // l : 1, 3, 2
		assertEquals(l.getNElements(), 3);
		
		l.insertarValor(0, 2); // l : 2, 1, 3, 2
		assertEquals(l.getPrimerElem().getValor(), 2);
		assertEquals(l.getPrimerElem().getNext().getValor(), 1);
		assertEquals(l.getNElements(), 4);
	}

	@Test
	void testEliminaValor() {
		Llista l = new Llista();
		l.afegirUltim(1); // l : 1
		l.insertarValor(1, 2); // l : 1, 2
		l.insertarValor(2, 3); // l : 1, 2, 3
		
		l.eliminaValor(1); // l : 1, 3
		assertEquals(l.getPrimerElem().getNext().getValor(), 3);
		assertEquals(l.getNElements(), 2);
	}

	@Test
	void testGetValor() {
		Llista l = new Llista();
		l.afegirUltim(1); // l : 1
		l.insertarValor(1, 2); // l : 1, 2
		l.insertarValor(2, 3); // l : 1, 2, 3
		
		assertEquals(l.getValor(1), 2);
		assertEquals(l.getValor(0), 1);
		assertEquals(l.getValor(2), 3);
	}

	@Test
	void testEsBuida() {
		Llista l = new Llista();
		assertEquals(l.esBuida(), true);
		
		l.afegirUltim(1); // l : 1
		l.insertarValor(1, 2); // l : 1, 2
		
		assertEquals(l.esBuida(), false);
	}

	@Test
	void testGetNElements() {
		Llista l = new Llista();
		assertEquals(l.getNElements(), 0);
		
		l.afegirUltim(1); // l : 1
		l.insertarValor(1, 2); // l : 1, 2
		
		assertEquals(l.getNElements(), 2);
	}

}
