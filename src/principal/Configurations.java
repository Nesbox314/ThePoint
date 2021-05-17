package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import utils.Reader;

public class Configurations {
	
	Reader reader = new Reader();

	public void menu() {
		System.out.println("-----------------------CONFIGURAÇÕES-----------------------");
		System.out.println("O que você deseja fazer por aqui?");
		System.out.println("1 - Ler as configurações");
		System.out.println("2 - Alterar as configurações");
		System.out.println("3 - Voltar ao menu");
		int opcao = reader.getLeitor().nextInt();

		try {
			File file = new File("registros.txt");
			BufferedReader br;
			br = new BufferedReader(new FileReader(file));
			
			if(opcao == 1) {
			    String stringConfigs;
			    stringConfigs = br.readLine();
			    System.out.println(stringConfigs);
			    stringConfigs = br.readLine();
			    System.out.println(stringConfigs);
			    stringConfigs = br.readLine();
			    System.out.println(stringConfigs);
			}
			
			if(opcao == 2) {
			    String stringConfigs;
				stringConfigs = br.readLine();
			    System.out.println(stringConfigs);
			    stringConfigs = br.readLine();
			    String nome = stringConfigs;
			    stringConfigs = br.readLine();
			    String cargaHoraria = stringConfigs;
	
			    System.out.println(nome);
			    System.out.println(cargaHoraria);
			}
	
			br.close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//leitor.close();
	}
	
	public void lerConfigs(){
		
	}
	
	public void alterarConfigs(){
		
	}
}
