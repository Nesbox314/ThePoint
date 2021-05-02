package principal;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
		
		while(exit) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("O que deseja? Digite a opção escolhida");
			System.out.println("1- Calcular horário de saída");
			System.out.println("2- Calcular total de horas extras");
			System.out.println("3- Registrar batida de ponto (hoje) (EM DESENVOLVIMENTO)");
			System.out.println("4- Adicionar / editar batida de ponto anterior (EM DESENVOLVIMENTO)");
			System.out.println("5- Configurações (EM DESENVOLVIMENTO)");
			System.out.println("0- Sair");
			int opcaoMenu = leitor.nextInt();
			
			if(opcaoMenu == 1) {
				System.out.println("Digite o horário de entrada:");
				String horaEntrada = leitor.next();
				Hour horaEntradaObject = dateConverter.converteData(horaEntrada);
				
				System.out.println("Digite o horário de ida ao almoço:");
				String horaSaidaAlmoco = leitor.next();
				Hour horaSaidaAlmocoObject = dateConverter.converteData(horaSaidaAlmoco);
				
				System.out.println("Digite o horário do retorno do almoço:");
				String horaVoltaAlmoco = leitor.next();
				Hour horaVoltaAlmocoObject = dateConverter.converteData(horaVoltaAlmoco);
				
				Hour horaDeSaida = workCalculator.calculaHoraSaida(horaEntradaObject, horaSaidaAlmocoObject, horaVoltaAlmocoObject);
				horaDeSaida = dateConverter.converteFormatoData(horaDeSaida);
				
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("Você deverá sair as: " + dateConverter.dateFormatter(horaDeSaida)); 
				System.out.println("-------------------------------------------------------------------------------");
			}
			
			if(opcaoMenu == 2) {
				System.out.println("Digite o horário de entrada:");
				String horaEntrada = leitor.next();
				Hour horaEntradaObject = dateConverter.converteData(horaEntrada);
				
				System.out.println("Digite o horário de ida ao almoço:");
				String horaSaidaAlmoco = leitor.next();
				Hour horaSaidaAlmocoObject = dateConverter.converteData(horaSaidaAlmoco);
				
				System.out.println("Digite o horário do retorno do almoço:");
				String horaVoltaAlmoco = leitor.next();
				Hour horaVoltaAlmocoObject = dateConverter.converteData(horaVoltaAlmoco);
				
				System.out.println("Digite o horário de saída:");
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
					System.out.println("Não foi possível encontrar o seu arquivo de registros!");
					System.out.println("Você deseja criar? 1 para SIM | 2 para NÃO");
					int opcaoArq = leitor.nextInt();
					
					if(opcaoArq == 1) {
						file = fileWorker.criaArquivo();
						System.out.println("Okay, arquivo criado, vamos as configurações...");
						System.out.println("Qual é seu nome?");
						String nome = leitor.next();
						System.out.println("Quanto é sua carga horária?");
						String cargaHoraria = leitor.next();
						fileWorker.preencheConfigs(nome, cargaHoraria);
						System.out.println("Arquivo criado e configurado! Opção liberada.");
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
