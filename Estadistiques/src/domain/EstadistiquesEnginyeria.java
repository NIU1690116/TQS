package domain;

public class EstadistiquesEnginyeria {
	
	private DB db;

    public EstadistiquesEnginyeria(DB db) {
        this.db = db;
    }

	public double PerCentAprovats(String Assignatura, String Nota) {
		db.connect();
		String query = "SELECT * FROM notas WHERE assignatura = '" + Assignatura + "'";
		String [][] dades = db.query(query);
		db.close();
		
		if (dades == null || dades.length == 0) {
			return 0.0;
		} 
		
		double totalAlumnes = dades.length;
		double comptador = 0;
		int indexColumna = 0;
		
		switch (Nota) {
			case "NTeo": 
				indexColumna = 2;
			case "NPract": 
				indexColumna = 3;
			case "NFinal": 
				indexColumna = 4;
			default: 
				indexColumna = 4;
		}

		for (int i = 0; i < dades.length; i++) {
			String valorNota = dades[i][indexColumna];
			if (!valorNota.equalsIgnoreCase("NP") || !valorNota.trim().isEmpty()) {
				double notaNum = Double.parseDouble(valorNota);
				if (notaNum >= 5.0) {
					comptador++;
				}
			}
		}
		return (comptador / totalAlumnes) * 100.0;
	}
	
	public double PerCentSuspesos(String Assignatura, String Nota) {
		
		db.connect();
		String query = "SELECT * FROM notas WHERE assignatura = '" + Assignatura + "'";
		String [][] dades = db.query(query);
		db.close();
		
		if (dades == null || dades.length == 0) {
			return 0.0;
		} 
		
		double totalAlumnes = dades.length;
		double comptador = 0;
		int indexColumna = 0;
		
		switch (Nota) {
			case "NTeo": 
				indexColumna = 2;
			case "NPract": 
				indexColumna = 3;
			case "NFinal": 
				indexColumna = 4;
			default: 
				indexColumna = 4;
		}

		for (int i = 0; i < dades.length; i++) {
			String valorNota = dades[i][indexColumna];
			if (!valorNota.equalsIgnoreCase("NP") || !valorNota.trim().isEmpty()) {
				double notaNum = Double.parseDouble(valorNota);
				if (notaNum <= 5.0) {
					comptador++;
				}
			}
		}
		return (comptador / totalAlumnes) * 100.0;
	}
	public double PerCentNoPresentats(String Assignatura, String Nota) {
		
		db.connect();
		String query = "SELECT * FROM notas WHERE assignatura = '" + Assignatura + "'";
		String [][] dades = db.query(query);
		db.close();
		
		if (dades == null || dades.length == 0) {
			return 0.0;
		} 
		
		double totalAlumnes = dades.length;
		double comptador = 0;
		int indexColumna = 0;
		
		switch (Nota) {
			case "NTeo": 
				indexColumna = 2;
			case "NPract": 
				indexColumna = 3;
			case "NFinal": 
				indexColumna = 4;
			default: 
				indexColumna = 4;
		}

		for (int i = 0; i < dades.length; i++) {
			String valorNota = dades[i][indexColumna];
			if (valorNota.equals("NP")) {
				comptador++;
			}
		}
		return (comptador / totalAlumnes) * 100.0;
	}
	
	
	
}
