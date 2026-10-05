package test;

import domain.DB;

public class MockDB implements DB{

	public boolean connect() {
		return false;
	}

	public String[][] query(String q) {
		return null;
	}

	public boolean close() {
		return false;
	}



}
