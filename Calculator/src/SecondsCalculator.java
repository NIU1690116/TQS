import java.time.LocalDateTime;

public class SecondsCalculator {
	
	private int anyInicial = 1980;
	private int mesInicial = 1;
	private int diaInicial = 1;
	private int horaInicial = 0;
	
	public long SeconsFins(int dia, int mes, int any, int hora, int minuts, int segons) {
		int acumuladorSec = 0;
		int secDelDia = 24 * 3600;
	
		if (isFechaValid(dia, mes, any, hora, minuts, segons)) {
			
			for (int any_i = anyInicial; any_i < any; any_i++) {
				for (int mes_j = 1; mes_j < 13; mes_j++) {
					int acumDies = DiesDelMes(mes_j, any_i);
					acumuladorSec += acumDies * secDelDia;
				}
			}
			for (int mes_j = 1; mes_j < mes; mes_j++) {
	            int acumDies = DiesDelMes(mes_j, any);
	            acumuladorSec += acumDies * secDelDia;
	        }
			
			acumuladorSec += (dia - 1) * secDelDia;

	        acumuladorSec += hora * 3600;
	        acumuladorSec += minuts * 60;
	        acumuladorSec += segons;
		}
		return acumuladorSec;
	}
	
	private boolean IsAnyTraspas(int any) {

		if (any % 400 == 0) {
			return true;
		}
		if (any % 100 == 0) {
			return false;
		}
		
		if (any % 4 == 0) {
			return true;
		}
		
		return false;
	}
	
	private int DiesDelMes(int mes, int any) {
		if (mes == 2) {
			if (IsAnyTraspas(any) == true) {
				return 29;
			}
			return 28;
		}

		if (mes == 4 || mes == 6|| mes == 9 || mes == 11) {
			return 30;
		}
		return 31;

	}
	
	private int SecondsDelMes(int mes, int any) {
		int diesDelMes = DiesDelMes(mes, any);
		int secDelDia = 24 * 3600;
		int secDelMes = diesDelMes * secDelDia;
		
		return secDelMes;
	}
	
	public boolean isForaRang(int dia, int mes, int any, int hora, int minuts, int segons) {
		
		if (mes < 1 || mes > 12) {
			return true;
		}
		if (dia < 1 || dia > 31) {
			return true;
		}
		if (hora < 0 || hora > 23) {
			return true;
		}
		if (minuts < 0 || minuts > 59) {
			return true;
		}
		if (segons < 0 || segons > 59) {
			return true;
		}
		return false;
		 
	}
	
	public boolean isFechaValid(int dia, int mes, int any, int hora, int minuts, int segons) {
		
		if(!isForaRang(dia, mes, any, hora, minuts, segons)) {
			if (any < anyInicial) {
				return false;
			}
			if (any == anyInicial) {
				if (mes < mesInicial) {
					return false;
				}
				if (mes == mesInicial) {
					if (dia < diaInicial) {
						return false;
					}
					return true;	
				}
				return true;
			}
			return true;
		}
		return false;
	}
	
	
	public boolean getIsAnyTraspas(int any) {
		return IsAnyTraspas(any);
	}
	
	public int getDiesDelMes(int mes, int any) {
		return DiesDelMes(mes, any);
	}
	
	public int getSecondsDelMes(int mes, int any) {
		return SecondsDelMes(mes, any);
	}

	


}
