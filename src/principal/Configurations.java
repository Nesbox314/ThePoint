package principal;

import java.util.Scanner;

public class Configurations {
	Scanner leitor = new Scanner(System.in);

	public Configurations() {
		System.out.println("-----------------------CONFIGURA��ES-----------------------");
		System.out.println("O que voc� deseja fazer por aqui?");
		System.out.println("1 - Ler as configura��es");
		System.out.println("2 - Alterar as configura��es");
		System.out.println("3 - Voltar ao menu");
		int opcao = leitor.nextInt();
		
		if(opcao == 1) {
			//ler as configura��es
		}
		
		if(opcao == 2) {
			//alterar as configura��es
		}

		if(opcao == 3) {}
	}
	
	public void lerConfigs(){
		
	}
	
	public void alterarConfigs(){
		
	}
}
