package domain;

public class EstadistiquesEnginyeria {
	
	private DB db;

    public EstadistiquesEnginyeria(DB db) {
        this.db = db;
    }

	public double PerCentAprovats(String Assignatura, String Nota) {
		return 0;
	}
	public double PerCentSuspesos(String Assignatura, String Nota) {
		return 0;
	}
	public double PerCentNoPresentats(String Assignatura, String Nota) {
		return 0;
	}
	
	public void setDB(DB db) {
		this.db = db;
	}

}
