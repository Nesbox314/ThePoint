package utils;

import markers.Hour;

public class DateConverter {

	public Hour converteData(String data) {
		Hour momento = new Hour();
		
		String[] dataDividida = data.split(":");
		
		momento.setHoras(Integer.parseInt(dataDividida[0]));
		momento.setMinutos(Integer.parseInt(dataDividida[1]));
		
		return momento;
	}
}
