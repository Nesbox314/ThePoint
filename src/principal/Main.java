package principal;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import markers.Hour;
import utils.DateConverter;
import utils.WorkCalculator;

public class Main {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		WorkCalculator workCalculator = new WorkCalculator();
		Boolean exit = true;
		
		while(exit) {
			System.out.println("Bem vindo ao sistema de registro de ponto!");
			System.out.println("O que deseja? Digite a opção escolhida");
			System.out.println("1- Calcular horário de saída");
			System.out.println("2- Registrar batida de ponto (hoje)");
			System.out.println("3- Adicionar / editar batida de ponto anterior");
			System.out.println("0- Sair");
			int opcaoMenu = leitor.nextInt();
			
			if(opcaoMenu == 1) {
				DateConverter dateConverter = new DateConverter();
				
				System.out.println("Digite o horário de entrada:");
				String horaEntrada = leitor.next();
				Hour horaEntradaObject = dateConverter.converteData(horaEntrada);
				
				System.out.println("Digite o horário de entrada no almoço:");
				String horaSaidaAlmoco = leitor.next();
				Hour horaSaidaAlmocoObject = dateConverter.converteData(horaSaidaAlmoco);
				
				System.out.println("Digite o horário de volta do almoço:");
				String horaVoltaAlmoco = leitor.next();
				Hour horaVoltaAlmocoObject = dateConverter.converteData(horaVoltaAlmoco);
				
				Hour horaDeSaida = workCalculator.calculaHoraSaida(horaEntradaObject, horaSaidaAlmocoObject, horaVoltaAlmocoObject);
				
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("Você deverá sair as: " + horaDeSaida.getHoras() + ":" + horaDeSaida.getMinutos());
				System.out.println("-------------------------------------------------------------------------------");
			}
			
			if(opcaoMenu == 2) {
				System.out.println("Função em desenvolvimento!");
			}
			
			if(opcaoMenu == 3) {
				System.out.println("Função em desenvolvimento!");
			}
			
			if(opcaoMenu == 0) {
				exit = false;
			}
			
		}
		
		leitor.close();
	}

}
