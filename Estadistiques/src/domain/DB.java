package domain;

public interface DB {
	public boolean connect();
	public String[][] query(String q);//construim query SQL y tiene que ser valida
	public boolean close();
	

}
