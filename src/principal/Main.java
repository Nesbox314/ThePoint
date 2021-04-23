package principal;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Bem vindo ao sistema de registro de ponto!");
		System.out.println("O que deseja? Digite a op��o escolhida");
		System.out.println("1- Registrar batida de ponto (hoje)");
		System.out.println("2- Adicionar / editar batida de ponto anterior");
		System.out.println("0- Sair");
		
		Scanner leitor = new Scanner(System.in);
		int opcaoMenu = leitor.nextInt();
		
		if(opcaoMenu == 1) {
			DateConverter date = new DateConverter();
			
			System.out.println("Digite o hor�rio de entrada:");
			String horaEntrada = leitor.nextLine();
			Date horaEntradaObject = date.converteData(horaEntrada);
			
			System.out.println("Digite o hor�rio de entrada no almo�o:");
			String horaSaidaAlmoco = leitor.nextLine();
			Date horaSaidaAlmocoObject = date.converteData(horaSaidaAlmoco);
			
			System.out.println("Digite o hor�rio de volta do almo�o:");
			String horaVoltaAlmoco = leitor.nextLine();
			Date horaVoltaAlmocoObject = date.converteData(horaVoltaAlmoco);
			
			System.out.println("Digite o hor�rio de sa�da:");
			String horaSaida = leitor.nextLine();
			Date horaSaidaObject = date.converteData(horaSaida);
			
		}
		
		leitor.close();
		
	}

}
