package principal;

import java.io.File;
import java.util.Scanner;

import markers.Hour;
import utils.DateConverter;
import utils.FileWorker;
import utils.WorkCalculator;

public class Main {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		WorkCalculator workCalculator = new WorkCalculator();
		DateConverter dateConverter = new DateConverter();
		FileWorker fileWorker = new FileWorker();
		Boolean exit = true;
		
		System.out.println("Bem vindo ao sistema de registro de ponto!");
		
		System.out.println("	  _______ _            _____      _       _     ");
		System.out.println("	 |__   __| |          |  __ \\    (_)     | |    ");
		System.out.println("	    | |  | |__   ___  | |__) |__  _ _ __ | |_   ");
		System.out.println("	    | |  | '_ \\ / _ \\ |  ___/ _ \\| | '_ \\| __|  ");
		System.out.println("	    | |  | | | |  __/ | |  | (_) | | | | | |_   ");
		System.out.println("	    |_|  |_| |_|\\___| |_|   \\___/|_|_| |_|\\__|  ");
		                                               
		                                              
		
		while(exit) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("O que deseja? Digite a op��o escolhida");
			System.out.println("1- Calcular hor�rio de sa�da");
			System.out.println("2- Calcular total de horas extras");
			System.out.println("3- Registrar batida de ponto (hoje) (EM DESENVOLVIMENTO)");
			System.out.println("4- Adicionar / editar batida de ponto anterior (EM DESENVOLVIMENTO)");
			System.out.println("5- Configura��es (EM DESENVOLVIMENTO)");
			System.out.println("0- Sair");
			int opcaoMenu = leitor.nextInt();
			
			if(opcaoMenu == 1) {
				System.out.println("Digite o hor�rio de entrada:");
				String horaEntrada = leitor.next();
				Hour horaEntradaObject = dateConverter.converteData(horaEntrada);
				
				System.out.println("Digite o hor�rio de ida ao almo�o:");
				String horaSaidaAlmoco = leitor.next();
				Hour horaSaidaAlmocoObject = dateConverter.converteData(horaSaidaAlmoco);
				
				System.out.println("Digite o hor�rio do retorno do almo�o:");
				String horaVoltaAlmoco = leitor.next();
				Hour horaVoltaAlmocoObject = dateConverter.converteData(horaVoltaAlmoco);
				
				Hour horaDeSaida = workCalculator.calculaHoraSaida(horaEntradaObject, horaSaidaAlmocoObject, horaVoltaAlmocoObject);
				horaDeSaida = dateConverter.converteFormatoData(horaDeSaida);
				
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("Voc� dever� sair as: " + dateConverter.dateFormatter(horaDeSaida)); 
				System.out.println("-------------------------------------------------------------------------------");
			}
			
			if(opcaoMenu == 2) {
				System.out.println("Digite o hor�rio de entrada:");
				String horaEntrada = leitor.next();
				Hour horaEntradaObject = dateConverter.converteData(horaEntrada);
				
				System.out.println("Digite o hor�rio de ida ao almo�o:");
				String horaSaidaAlmoco = leitor.next();
				Hour horaSaidaAlmocoObject = dateConverter.converteData(horaSaidaAlmoco);
				
				System.out.println("Digite o hor�rio do retorno do almo�o:");
				String horaVoltaAlmoco = leitor.next();
				Hour horaVoltaAlmocoObject = dateConverter.converteData(horaVoltaAlmoco);
				
				System.out.println("Digite o hor�rio de sa�da:");
				String horaSaida = leitor.next();
				Hour horaSaidaObject = dateConverter.converteData(horaSaida);
				
				workCalculator.calculaHoraExtra(horaEntradaObject, horaSaidaAlmocoObject, horaVoltaAlmocoObject, horaSaidaObject);
			}
			
			if(opcaoMenu == 3) {
				System.out.println("Em desenvolvimento!");
		    }
			
			if(opcaoMenu == 5) {
				File file = null;
				Boolean existe = fileWorker.verificaExistenciaArquivo();
				
				if(existe) {
					file = new File("registros");
				} else {
					System.out.println("N�o foi poss�vel encontrar o seu arquivo de registros!");
					System.out.println("Voc� deseja criar? 1 para SIM | 2 para N�O");
					int opcaoArq = leitor.nextInt();
					
					if(opcaoArq == 1) {
						file = fileWorker.criaArquivo();
						System.out.println("Okay, arquivo criado, vamos as configura��es...");
						System.out.println("Qual � seu nome?");
						String nome = leitor.next();
						System.out.println("Quanto � sua carga hor�ria?");
						String cargaHoraria = leitor.next();
						fileWorker.preencheConfigs(nome, cargaHoraria);
						System.out.println("Arquivo criado e configurado! Op��o liberada.");
					}
					
				}
				
		    }
			
			
			if(opcaoMenu == 0) {
				exit = false;
			}
		}
		
		leitor.close();
	}

}
