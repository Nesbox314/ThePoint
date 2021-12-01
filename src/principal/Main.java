package principal;

import autoexit.AutoExit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import markers.Hour;
import markers.Mark;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import utils.DateConverter;
import utils.FileWorker;
import utils.Reader;
import utils.WorkCalculator;


public class Main
{

	public static void main(String[] args)
	{
		Reader reader = new Reader();
		WorkCalculator workCalculator = new WorkCalculator();
		DateConverter dateConverter = new DateConverter();
		FileWorker fileWorker = new FileWorker();
		Configurations configs = new Configurations();
		Boolean exit = true;

		System.out.println("	  _______ _            _____      _       _     ");
		System.out.println("	 |__   __| |          |  __ \\    (_)     | |    ");
		System.out.println("	    | |  | |__   ___  | |__) |__  _ _ __ | |_   ");
		System.out.println("	    | |  | '_ \\ / _ \\ |  ___/ _ \\| | '_ \\| __|  ");
		System.out.println("	    | |  | | | |  __/ | |  | (_) | | | | | |_   ");
		System.out.println("	    |_|  |_| |_|\\___| |_|   \\___/|_|_| |_|\\__|  ");
		System.out.println("");
		if (fileWorker.verificaExistenciaArquivoConfigs())
		{
			String[] dados = configs.getDadosConfiguracoes();
			System.out.println("Bem vindo ao sistema de registro de ponto, " + dados[0] + ".");
		}
		else
		{
			System.out.println("Bem vindo ao sistema de registro de ponto!");
		}
		;

		while (exit)
		{
			System.out.println(
				"-------------------------------------------------------------------------------");
			System.out.println("O que deseja? Digite a op��o escolhida");
			System.out.println("1- Calcular hor�rio de sa�da");
			System.out.println("2- Calcular total de horas extras");
			System.out.println("3- Configura��es");
			System.out.println("4- Checar horário de saída automaticamente");
			System.out.println("0- Sair");
			int opcaoMenu = reader.getLeitor().nextInt();

			if (opcaoMenu == 1)
			{
				System.out.println("Digite o hor�rio de entrada:");
				String horaEntrada = reader.getLeitor().next();
				Hour horaEntradaObject = dateConverter.converteData(horaEntrada);

				System.out.println("Digite o hor�rio de ida ao almo�o:");
				String horaSaidaAlmoco = reader.getLeitor().next();
				Hour horaSaidaAlmocoObject = dateConverter.converteData(horaSaidaAlmoco);

				System.out.println("Digite o hor�rio do retorno do almo�o:");
				String horaVoltaAlmoco = reader.getLeitor().next();
				Hour horaVoltaAlmocoObject = dateConverter.converteData(horaVoltaAlmoco);

				Hour horaDeSaida = workCalculator.calculaHoraSaida(horaEntradaObject,
					horaSaidaAlmocoObject, horaVoltaAlmocoObject);
				horaDeSaida = dateConverter.converteFormatoData(horaDeSaida);

				System.out.println(
					"-------------------------------------------------------------------------------");
				System.out.println("Voc� dever� sair as: " + dateConverter.dateFormatter(horaDeSaida));
				System.out.println(
					"-------------------------------------------------------------------------------");
			}

			if (opcaoMenu == 2)
			{
				System.out.println("Digite o hor�rio de entrada:");
				String horaEntrada = reader.getLeitor().next();
				Hour horaEntradaObject = dateConverter.converteData(horaEntrada);

				System.out.println("Digite o hor�rio de ida ao almo�o:");
				String horaSaidaAlmoco = reader.getLeitor().next();
				Hour horaSaidaAlmocoObject = dateConverter.converteData(horaSaidaAlmoco);

				System.out.println("Digite o hor�rio do retorno do almo�o:");
				String horaVoltaAlmoco = reader.getLeitor().next();
				Hour horaVoltaAlmocoObject = dateConverter.converteData(horaVoltaAlmoco);

				System.out.println("Digite o hor�rio de sa�da:");
				String horaSaida = reader.getLeitor().next();
				Hour horaSaidaObject = dateConverter.converteData(horaSaida);

				workCalculator.calculaHoraExtra(horaEntradaObject, horaSaidaAlmocoObject,
					horaVoltaAlmocoObject, horaSaidaObject);
			}

			if (opcaoMenu == 3)
			{
				Boolean existe = fileWorker.verificaExistenciaArquivoConfigs();

				if (existe)
				{
					configs.menu();
				}
				else
				{
					fileWorker.criaArquivoComConfigs();
				}

			}

			if (opcaoMenu == 4)
			{
				ArrayList<Hour> listaHoras = AutoExit.getListHours();
				Hour horaDeSaida = workCalculator.calculaHoraSaida(listaHoras.get(0), listaHoras.get(1),
					listaHoras.get(2));
				horaDeSaida = dateConverter.converteFormatoData(horaDeSaida);

				System.out.println(
					"-------------------------------------------------------------------------------");
				System.out.println("Voc� dever� sair as: " + dateConverter.dateFormatter(horaDeSaida));
				System.out.println(
					"-------------------------------------------------------------------------------");
			}

			if (opcaoMenu == 0)
			{
				exit = false;
			}
		}
	}

}
