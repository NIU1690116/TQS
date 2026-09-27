import static org.junit.jupiter.api.Assertions.fail;

public class Node {
	private int valor;
	private Node next;

	public Node() {
		this.valor = 0;
		this.next = null;
	}
	
	public Node(int v) {
		this.valor = v;
		this.next = null;
	}
	
	public void setValor(int v) {
		this.valor = v;
		
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	

}
