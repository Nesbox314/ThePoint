package principal;

import markers.Hour;
import utils.DateConverter;
import utils.FileWorker;
import utils.Reader;
import utils.WorkCalculator;

public class Main {
	
	public static void main(String[] args) {
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
		if(fileWorker.verificaExistenciaArquivoConfigs()) {
			String[] dados = configs.getDadosConfiguracoes();
			System.out.println("Bem vindo ao sistema de registro de ponto, " + dados[0] + ".");
		} else {
			System.out.println("Bem vindo ao sistema de registro de ponto!");
		};
		                                              
		while(exit) {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("O que deseja? Digite a opção escolhida");
			System.out.println("1- Calcular horário de saída");
			System.out.println("2- Calcular total de horas extras");
			System.out.println("3- Configurações");
			System.out.println("0- Sair");
			int opcaoMenu = reader.getLeitor().nextInt();
			
			if(opcaoMenu == 1) {
				System.out.println("Digite o horário de entrada:");
				String horaEntrada = reader.getLeitor().next();
				Hour horaEntradaObject = dateConverter.converteData(horaEntrada);
				
				System.out.println("Digite o horário de ida ao almoço:");
				String horaSaidaAlmoco = reader.getLeitor().next();
				Hour horaSaidaAlmocoObject = dateConverter.converteData(horaSaidaAlmoco);
				
				System.out.println("Digite o horário do retorno do almoço:");
				String horaVoltaAlmoco = reader.getLeitor().next();
				Hour horaVoltaAlmocoObject = dateConverter.converteData(horaVoltaAlmoco);
				
				Hour horaDeSaida = workCalculator.calculaHoraSaida(horaEntradaObject, horaSaidaAlmocoObject, horaVoltaAlmocoObject);
				horaDeSaida = dateConverter.converteFormatoData(horaDeSaida);
				
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("Você deverá sair as: " + dateConverter.dateFormatter(horaDeSaida)); 
				System.out.println("-------------------------------------------------------------------------------");
			}
			
			if(opcaoMenu == 2) {
				System.out.println("Digite o horário de entrada:");
				String horaEntrada = reader.getLeitor().next();
				Hour horaEntradaObject = dateConverter.converteData(horaEntrada);
				
				System.out.println("Digite o horário de ida ao almoço:");
				String horaSaidaAlmoco = reader.getLeitor().next();
				Hour horaSaidaAlmocoObject = dateConverter.converteData(horaSaidaAlmoco);
				
				System.out.println("Digite o horário do retorno do almoço:");
				String horaVoltaAlmoco = reader.getLeitor().next();
				Hour horaVoltaAlmocoObject = dateConverter.converteData(horaVoltaAlmoco);
				
				System.out.println("Digite o horário de saída:");
				String horaSaida = reader.getLeitor().next();
				Hour horaSaidaObject = dateConverter.converteData(horaSaida);
				
				workCalculator.calculaHoraExtra(horaEntradaObject, horaSaidaAlmocoObject, horaVoltaAlmocoObject, horaSaidaObject);
			}
			
			if(opcaoMenu == 3) {
				Boolean existe = fileWorker.verificaExistenciaArquivoConfigs();
				
				if(existe) {
					configs.menu();
				} else {
					fileWorker.criaArquivoComConfigs();
				}
				
		    }
			
			if(opcaoMenu == 0) {
				exit = false;
			}
		}
	}

}
