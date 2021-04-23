package principal;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateConverter {

	public Date converteData(String data) {
		
		int horas;
		int minutos;
		
		String[] dataDividida = data.split(":");
		horas = Integer.parseInt(dataDividida[0]);
		minutos = Integer.parseInt(dataDividida[1]);
		
		Date hourObject = new Date();
		hourObject.setHours(horas);
		hourObject.setMinutes(minutos);
		
		return hourObject;
	}
}
