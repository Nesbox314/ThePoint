package principal;

import java.util.Scanner;

import markers.Hour;
import utils.DateConverter;
import utils.WorkCalculator;

public class Main {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		WorkCalculator workCalculator = new WorkCalculator();
		DateConverter dateConverter = new DateConverter();
		Boolean exit = true;
		
		while(exit) {
			System.out.println("Bem vindo ao sistema de registro de ponto!");
			System.out.println("O que deseja? Digite a op��o escolhida");
			System.out.println("1- Calcular hor�rio de sa�da");
			System.out.println("2- Calcular tempo de hora extra (EM DESENVOLVIMENTO)");
			System.out.println("3- Registrar batida de ponto (hoje) (EM DESENVOLVIMENTO)");
			System.out.println("4- Adicionar / editar batida de ponto anterior (EM DESENVOLVIMENTO)");
			System.out.println("0- Sair");
			int opcaoMenu = leitor.nextInt();
			
			if(opcaoMenu == 1) {
				System.out.println("Digite o hor�rio de entrada:");
				String horaEntrada = leitor.next();
				Hour horaEntradaObject = dateConverter.converteData(horaEntrada);
				
				System.out.println("Digite o hor�rio de entrada no almo�o:");
				String horaSaidaAlmoco = leitor.next();
				Hour horaSaidaAlmocoObject = dateConverter.converteData(horaSaidaAlmoco);
				
				System.out.println("Digite o hor�rio de volta do almo�o:");
				String horaVoltaAlmoco = leitor.next();
				Hour horaVoltaAlmocoObject = dateConverter.converteData(horaVoltaAlmoco);
				
				Hour horaDeSaida = workCalculator.calculaHoraSaida(horaEntradaObject, horaSaidaAlmocoObject, horaVoltaAlmocoObject);
				horaDeSaida = dateConverter.converteFormatoData(horaDeSaida);
				
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("Voc� dever� sair as: " + dateConverter.dateFormatter(horaDeSaida)); 
				System.out.println("-------------------------------------------------------------------------------");
			}
			
			if(opcaoMenu == 2) {
				System.out.println("Fun��o em desenvolvimento!");
			}
			
			if(opcaoMenu == 3) {
				System.out.println("Fun��o em desenvolvimento!");
			}
			
			if(opcaoMenu == 0) {
				exit = false;
			}
		}
		
		leitor.close();
	}

}
