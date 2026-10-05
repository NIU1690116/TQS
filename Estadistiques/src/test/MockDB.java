package test;

import domain.DB;

public class MockDB implements DB{
	private boolean connected = false;

	public boolean connect() {
		this.connected = true;
		return this.connected;
	}

	public String[][] query(String q) {
		if (!connected) {
            throw new IllegalStateException("La base de dades no està connectada");
        }
		if (q.contains("FISICA")) {
            return new String[][] {
                {"11111", "FISICA", "7.5", "8.0", "7.7"},
                {"22222", "FISICA", "4.0", "3.0", "3.5"},
                {"33333", "FISICA", "NP",  "5.0", "NP"},
                {"44444", "FISICA", "5.0", "6.0", "5.5"}
            };
        }
        
        return new String[0][0];
      
	}

	public boolean close() {
		this.connected = false;
		return this.connected;
	}



}
