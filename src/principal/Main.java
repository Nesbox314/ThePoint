package principal;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import markers.Hour;
import utils.DateConverter;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Bem vindo ao sistema de registro de ponto!");
		System.out.println("O que deseja? Digite a opção escolhida");
		System.out.println("1- Registrar batida de ponto (hoje)");
		System.out.println("2- Adicionar / editar batida de ponto anterior");
		System.out.println("0- Sair");
		
		Scanner leitor = new Scanner(System.in);
		int opcaoMenu = leitor.nextInt();
		
		if(opcaoMenu == 1) {
			DateConverter dateConverter = new DateConverter();
			
			System.out.println("Digite o horário de entrada:");
			String horaEntrada = leitor.nextLine();
			Hour horaEntradaObject = dateConverter.converteData(horaEntrada);
			
			System.out.println("Digite o horário de entrada no almoço:");
			String horaSaidaAlmoco = leitor.nextLine();
			Hour horaSaidaAlmocoObject = dateConverter.converteData(horaSaidaAlmoco);
			
			System.out.println("Digite o horário de volta do almoço:");
			String horaVoltaAlmoco = leitor.nextLine();
			Hour horaVoltaAlmocoObject = dateConverter.converteData(horaVoltaAlmoco);
			
			System.out.println("Digite o horário de saída:");
			String horaSaida = leitor.nextLine();
			Hour horaSaidaObject = dateConverter.converteData(horaSaida);
			
			//criar método de cálculo de hora passando todos os objetos + o dia em que foi executado
			
		}
		
		leitor.close();
		
	}

}
