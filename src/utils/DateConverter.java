package utils;

import markers.Hour;

public class DateConverter
{

	public DateConverter()
	{

	}

	public Hour converteData(String data)
	{
		Hour momento = new Hour();

		String[] dataDividida = data.split(":");

		momento.setHoras(Integer.parseInt(dataDividida[0]));
		momento.setMinutos(Integer.parseInt(dataDividida[1]));

		return momento;
	}

	public Hour converteFormatoData(Hour horaDeSaida)
	{
		int horas = horaDeSaida.getHoras();

		if (horas < 12)
		{
			horaDeSaida.setHoras(horas + 12);
		}

		return horaDeSaida;
	}

	public String dateFormatter(Hour horaDeSaida)
	{
		String horaString;
		int horas = horaDeSaida.getHoras();
		int minutos = horaDeSaida.getMinutos();

		if (horas < 10)
		{
			horaString = "0" + String.valueOf(horas);
		}
		else
		{
			horaString = String.valueOf(horas);
		}

		horaString = horaString + ":";

		if (minutos < 10)
		{
			horaString = horaString + "0" + String.valueOf(minutos);
		}
		else
		{
			horaString = horaString + String.valueOf(minutos);
		}

		return horaString;
	}
}
