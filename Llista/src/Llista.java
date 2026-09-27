

public class Llista {
	private Node primer;
	private int numElements;
	
	public Llista() {
		this.primer = null;
		this.numElements = 0;
	}
	
	public boolean afegirUltim(int valor) {
		Node nou = new Node(valor);
		if(esBuida()) {
			this.primer = nou;
		}else {
			Node actual = this.primer;
			while(actual.getNext() != null) {
				actual = actual.getNext();
				
			}
			actual.setNext(nou);
		}
		this.numElements++;
		return true;
	}
	
	public boolean insertarValor(int posicio, int valor) {
		if(posicio > numElements) {
			return false;
		}
		
		if(posicio == 0) {
			Node nou = new Node(valor);
			nou.setNext(this.primer);
			this.primer = nou;
		}else {
			Node actual = this.primer;
			for(int i = 0; i < posicio - 1; i++) {
				actual = actual.getNext();
			}
			Node nou = new Node(valor);
			nou.setNext(actual.getNext());
			actual.setNext(nou);
		}
		this.numElements++;
		return true;
	}
	
	public boolean eliminaValor(int posicio) {
		if(posicio > this.numElements) {
			return false;
		}
		if(posicio == 0) {
			Node actual = this.primer;
			this.primer = actual.getNext();
		}else {
			Node actual = this.primer;
			for(int i = 0; i < posicio - 1; i++) {
				actual = actual.getNext();
			}
			actual.setNext(actual.getNext().getNext());
		}
		this.numElements --;
		return true;
	}
	
	public int getValor(int posicio) {
		if(posicio > this.numElements) {
			return 0;
		}
		Node actual = this.primer;
		for(int i = 0; i < posicio; i++) {
			actual = actual.getNext();
		}
		return actual.getValor();
	}
	
	public boolean esBuida() {
		if (this.numElements == 0) {
			return true;
		}
		return false;
	}
	
	public int getNElements() {
		return this.numElements;
	}
	
	public Node getPrimerElem() {
		return this.primer;
	}
	

	

}
