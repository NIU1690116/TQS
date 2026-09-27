import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeTest {
	
	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@Test
	void testNode() {
		Node n = new Node();
		assertEquals(null, n.getNext());
	}

	@Test
	void testNodeInt() {
		Node n = new Node(1);
		assertEquals(n.getValor(), 1);
		assertEquals(n.getNext(), null);
	}

	@Test
	void testSetValor() {
		Node n = new Node(2);
		n.setValor(3);
		assertEquals(n.getValor(), 3);
	}

	@Test
	void testGetNext() {
		Node n = new Node();
		assertEquals(n.getNext(), null);
	}

	@Test
	void testSetNext() {
		Node n = new Node();
		n.setNext(n);
		assertEquals(n.getNext(), null);
	}

}
