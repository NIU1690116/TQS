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
	
	private int obtenirIndexColumna(String nota) {
		switch (nota) {
			case "NTeo": return 2;
			case "NPract": return 3;
			case "NFinal": return 4;
			default: return 4; // Per defecte NFinal
		}
	}
	
	private double calcularPercentatge(String assignatura, String tipusNota, String criteri) {
		db.connect();
		String query = "SELECT * FROM notas WHERE assignatura = " + assignatura;
		String[][] dades = db.query(query);
		db.close();

		if (dades == null || dades.length == 0) {
			return 0.0;
		}

		int totalAlumnes = dades.length;
		int comptador = 0;
		int indexColumna = obtenirIndexColumna(tipusNota);

		for (int i = 0; i < totalAlumnes; i++) {
			String valorNota = dades[i][indexColumna];

			if (valorNota.equalsIgnoreCase("NP") || valorNota.trim().isEmpty()) {
				if (criteri == "No Presentat") {
					comptador++;
				}
			} else {
				double notaNum = Double.parseDouble(valorNota);
				if (criteri == "Aprovat" && notaNum >= 5.0) {
					comptador++;
				} else if (criteri == "Suspes" && notaNum < 5.0) {
					comptador++;
				}
			}
		}
		Double porcentatge = comptador / totalAlumnes * 100.0;
		return porcentatge;
	}

}
