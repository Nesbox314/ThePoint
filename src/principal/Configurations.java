package principal;

import java.util.Scanner;

public class Configurations {
	Scanner leitor = new Scanner(System.in);

	public Configurations() {
		System.out.println("-----------------------CONFIGURAÇÕES-----------------------");
		System.out.println("O que você deseja fazer por aqui?");
		System.out.println("1 - Ler as configurações");
		System.out.println("2 - Alterar as configurações");
		System.out.println("3 - Voltar ao menu");
		int opcao = leitor.nextInt();
		
		if(opcao == 1) {
			//ler as configurações
		}
		
		if(opcao == 2) {
			//alterar as configurações
		}

		if(opcao == 3) {}
	}
	
	public void lerConfigs(){
		
	}
	
	public void alterarConfigs(){
		
	}
}
