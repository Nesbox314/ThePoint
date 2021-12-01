package markers;

public class Hour
{

	private int horas;
	private int minutos;

	public Hour()
	{

	}

	public Hour(int horas, int minutos)
	{
		setHoras(horas);
		setMinutos(minutos);
	}

	public int getHoras()
	{
		return horas;
	}

	public void setHoras(int horas)
	{
		this.horas = horas;
	}

	public int getMinutos()
	{
		return minutos;
	}

	public void setMinutos(int minutos)
	{
		this.minutos = minutos;
	}

}
