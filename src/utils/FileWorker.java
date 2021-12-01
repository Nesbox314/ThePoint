package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWorker
{

	Reader reader = new Reader();

	public Boolean verificaExistenciaArquivoConfigs()
	{
		File file = new File("configuracoes.txt");

		return file.exists();
	}

	public Boolean verificaExistenciaArquivoRegistro()
	{
		File file = new File("registros.txt");

		return file.exists();
	}

	public File criaArquivo()
	{
		File file = new File("configuracoes.txt");

		try
		{
			file.createNewFile();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return file;
	}

	public void criaArquivoComConfigs()
	{
		System.out.println("N�o foi poss�vel encontrar o seu arquivo de configura��es!");
		System.out.println("Voc� deseja criar? 1 para SIM | 2 para N�O");
		int opcaoArq = reader.getLeitor().nextInt();

		if (opcaoArq == 1)
		{
			criaArquivo();
			System.out.println("Okay, arquivo criado, vamos as configura��es...");
			System.out.println("Qual � seu nome?");
			String nome = reader.getLeitor().next();
			System.out.println("Quanto � sua carga hor�ria?");
			String cargaHoraria = reader.getLeitor().next();
			preencheConfigs(nome, cargaHoraria);
			System.out.println("Arquivo criado e configurado! Op��o liberada.");
		}

		if (opcaoArq == 2)
		{
			System.out.println("Okay! Retornando ao menu");
		}

	}

	public void preencheConfigs(String nome, String cargaHoraria)
	{
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter("configuracoes.txt", true));
			writer.write("ThePoint");
			writer.newLine();
			writer.write("Nome: |" + nome + "|");
			writer.newLine();
			writer.write("Carga hor�ria: |" + cargaHoraria + "|");
			writer.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void limpaArquivoConfiguracoes()
	{
		Writer clean;
		try
		{
			clean = new BufferedWriter(new FileWriter(new File("configuracoes.txt")));
			clean.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void publicaRegistroPonto(String dia, String horaEntrada, String horaSaidaAlmoco,
		String horaVoltaAlmoco, String horaSaida)
	{
		try
		{
			if (!verificaExistenciaArquivoRegistro())
			{
				File file = new File("registros.txt");
				file.createNewFile();
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter("registros.txt", true));
			writer.newLine();
			writer.write(
				"[" + dia + "] " + horaEntrada + " | " + horaSaidaAlmoco + " | " + horaVoltaAlmoco
					+ " | " + horaSaida);
			writer.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
