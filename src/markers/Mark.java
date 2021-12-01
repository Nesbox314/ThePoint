package markers;

public class Mark
{
	private String dataHora;
	private String origem;
	private Coordinate coordenadas = null;

	public String getDataHora()
	{
		return dataHora;
	}

	public String getHora()
	{
		return dataHora.substring(11, 13);
	}

	public String getMinuto()
	{
		return dataHora.substring(14, 16);
	}

	public String getOrigem()
	{
		return origem;
	}

	public Coordinate getCoordenadas()
	{
		return coordenadas;
	}

	public void setDataHora(String dataHora)
	{
		this.dataHora = dataHora;
	}

	public void setOrigem(String origem)
	{
		this.origem = origem;
	}

	public void setCoordenadas(Coordinate coordenadas)
	{
		this.coordenadas = coordenadas;
	}
}
